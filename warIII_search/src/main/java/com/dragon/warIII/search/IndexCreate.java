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

public class IndexCreate {

	public static void main(String[] args) {
		//1.指定索引分词器
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);
		
		//2.创建IndexWrite的配置信息
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_43, analyzer);
		
		//3.设置索引的打开方式
		indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);//有就新建,没有就打开
		
		//4.创建Directory和IndexWrite对象
		Directory directory = null;
		IndexWriter indexWrite = null;
		try {
			directory = FSDirectory.open(new File("D://Lucene/index/test"));
			if (indexWrite.isLocked(directory)) {//判断是否被锁上
				indexWrite.unlock(directory);
			}
			indexWrite = new IndexWriter(directory, indexWriterConfig);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//5.创建一个文档
		Document doc1 = new Document();
		doc1.add(new StringField("id", "abcde", Store.YES));//id域
		doc1.add(new TextField("content", "极客学院", Store.YES));//文本域
		doc1.add(new IntField("num", 1, Store.YES));//数值域
		
		//6.将文档写到索引中
		try {
			indexWrite.addDocument(doc1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Document doc2 = new Document();
		doc2.add(new StringField("id", "asdff", Store.YES));//id域
		doc2.add(new TextField("content", "Lucene案例开发", Store.YES));//文本域
		doc2.add(new IntField("num", 2, Store.YES));//数值域
		
		try {
			indexWrite.addDocument(doc2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//7.将IndexWriter提交,并关闭相关的资源
		try {
			indexWrite.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (indexWrite != null) {
				try {
					indexWrite.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
	}
}


















