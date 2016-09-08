package com.dragon.warIII.search;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * @description 功能描述: 创建索引文件
 * @author 作 者: L.D
 * @createdate 建立日期：2016-9-9
 * @projectname 项目名称: warIII_search
 * @packageclass 包及类名: com.dragon.warIII.search  IndexCreate.java
 */
public class IndexCreate {

	public static void main(String[] args) {
		//1.指定索引分词器(首先,我们需要定义一个词法分析器,这里面使用标准的词法分析器,如果专门针对汉语,还可以搭配paoding,进行使用.)
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);
		
		//2.指定索引文件存放位置(其次,创建Directory对象,确定索引文件的位置.Lucene提供给我们两种方式：1.本地文件存储 2.内存存储,可以根据自己的需要而设定.)
		Directory directory = null;
		try {
			directory = FSDirectory.open(new File("D://Lucene/index/test"));//本地存储
//			directory = new RAMDirectory();//内存存储
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//3.创建IndexWriter对象
		//3.1.创建IndexWriter的配置信息(这里的IndexWriterConfig,据官方文档介绍,是对indexWriter的配置,其中包含了两个参数,第一个是目前的版本，第二个是词法分析器Analyzer。)
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_43, analyzer);
		//3.2.设置索引的打开方式
		indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);//没有就新建,有就打开后在后边追加.
		//3.3.创建IndexWriter对象
		IndexWriter indexWriter = null;
		try {
			if (IndexWriter.isLocked(directory)) {//判断是否被锁上
				IndexWriter.unlock(directory);
			}
			indexWriter = new IndexWriter(directory, indexWriterConfig);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//4.创建文档(Document类似一张表的一条数据,Field类似一行里面的一列)
		Document doc1 = new Document();
		doc1.add(new StringField("id", "abcde", Store.YES));//id域
		doc1.add(new TextField("content", "极客学院", Store.YES));//文本域
		doc1.add(new IntField("num", 1, Store.YES));//数值域
		
		Document doc2 = new Document();
		doc2.add(new StringField("id", "asdff", Store.YES));//id域
		doc2.add(new TextField("content", "Lucene案例开发", Store.YES));//文本域
		doc2.add(new IntField("num", 2, Store.YES));//数值域
		
		//5.将文档对象加入到索引创建中,并将IndexWriter提交,最后关闭相关的资源.
		try {
			indexWriter.addDocument(doc1);
			indexWriter.addDocument(doc2);
			
			indexWriter.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (indexWriter != null) {
				try {
					indexWriter.close();
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
		
		System.out.println("create index end.");
	}
	
}


















