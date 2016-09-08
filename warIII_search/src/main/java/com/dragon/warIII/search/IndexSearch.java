package com.dragon.warIII.search;

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
		//1.指定分词器
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);
		
		//2.打开索引存储位置.
		Directory directory = null;
		DirectoryReader ireader= null;
		try {
			directory = FSDirectory.open(new File("D://Lucene/index/test"));
			ireader = DirectoryReader.open(directory);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//3.创建搜索器.
		IndexSearcher isearcher = new IndexSearcher(ireader);
		
		//4.类似SQL,进行关键字查询.
		QueryParser parser = new QueryParser(Version.LUCENE_43, "content", analyzer);
		Query query = null;
		ScoreDoc[] hits = null;
		try {
			query = parser.parse("开学");
			
			hits = isearcher.search(query, null, 1000).scoreDocs;
			
			for (int i = 0; i < hits.length; i++) {
				Document hitDoc = isearcher.doc(hits[i].doc);
				System.out.println("$$$$$$$$$$$$$$$$$$$");
				System.err.println(hitDoc.get("id"));
				System.err.println(hitDoc.get("content"));
				System.err.println(hitDoc.get("num"));
				System.out.println("$$$$$$$$$$$$$$$$$$$");
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
		
		System.out.println("search index end.");
		
		/*		
			abcde
			极客学院
			1
			asdff
			Lucene案例开发
			2
		*/
	}
}












