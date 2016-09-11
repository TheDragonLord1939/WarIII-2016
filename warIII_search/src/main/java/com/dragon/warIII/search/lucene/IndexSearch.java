package com.dragon.warIII.search.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * @description 功能描述: 关键字查询
 * @author 作 者: L.D
 * @createdate 建立日期：2016-9-9
 * @projectname 项目名称: warIII_search
 * @packageclass 包及类名: com.dragon.warIII.search  IndexSearch.java
 */
public class IndexSearch {

	public static void main(String[] args) {
		//1.指定分词器(需要和创建索引时使用的分词器是一样的.)
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);
		
		//2.打开索引存储位置.
		Directory directory = null;
		DirectoryReader ireader= null;
		try {
			directory = FSDirectory.open(new File("D://Lucene/index/test"));
			ireader = DirectoryReader.open(directory);	//用于读取硬盘上的索引文件
		} catch (IOException e) {
			e.printStackTrace();
		}

		//3.创建搜索器.
		IndexSearcher isearcher = new IndexSearcher(ireader);	//提供了索引的检索方法
		
		//4.类似SQL,进行关键字查询.
		QueryParser parser = new QueryParser(Version.LUCENE_43, "content", analyzer);//主要用于对单个域进行搜索时,创建查询Query,要指定域名和分词方法.
		Query query = null;
		TopDocs topDocs = null;
		ScoreDoc[] hits = null;
		try { 
			query = parser.parse("开学");	//提供了查询条件的创建
			
			topDocs = isearcher.search(query, null, 1000);
			
			hits = topDocs.scoreDocs;
			
			if (topDocs != null) {
				System.out.println("符合条件的文档总数为: " + topDocs.totalHits);
				
				for (int i = 0; i < hits.length; i++) {
					System.out.println("-----------------------------");
					Document hitDoc = isearcher.doc(hits[i].doc);
					System.out.println("id= " + hitDoc.get("id"));
					System.out.println("content= " + hitDoc.get("content"));
					System.out.println("num= " + hitDoc.get("num"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5.关闭查询器等.
			if (ireader != null) {
				try {
					ireader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (directory != null) {
				try {
					directory.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("-----------------------------");
		System.out.println("search index end.");
		
		/*		
			符合条件的文档总数为: 2
			-----------------------------
			id= abcde
			content= 极客学院
			num= 1
			-----------------------------
			id= asdff
			content= Lucene案例开发
			num= 2
			-----------------------------
			search index end.
		*/
	}
	
}












