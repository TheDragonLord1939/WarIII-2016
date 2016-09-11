package com.dragon.warIII.search.lucene.analyzer;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * @description 功能描述: Lucene分词器学习
 * @author 作 者: L.D
 * @createdate 建立日期：2016-9-11
 * @projectname 项目名称: warIII_search
 * @packageclass 包及类名: com.dragon.warIII.search.analyzer  AnalyzerStudy.java
 */
public class AnalyzerStudy {

	private static String str = "极客学院，Lucene 案例 开发";
	
	public static void print(Analyzer analyzer) {
		//1.将字符串对象转换为StringReader
		StringReader stringReader = new StringReader(str);	
		try {
			//2.使用分词器中的tokenStream方法进行分词
			TokenStream tokenStream = analyzer.tokenStream("", stringReader);
			tokenStream.reset();
			//3.获取分词结果的CharTermAttribute
			CharTermAttribute term = tokenStream.getAttribute(CharTermAttribute.class);
			System.out.println("分词技术：" + analyzer.getClass());
			//4.循环输出分词结果
			while (tokenStream.incrementToken()) {
				System.out.print(term.toString() + "|");
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Analyzer analyzer = null;
		
		//1.标准分词器
		analyzer = new StandardAnalyzer(Version.LUCENE_43);
		AnalyzerStudy.print(analyzer);
		//2.基于Lucene的第三方中文分词技术
		analyzer = new IKAnalyzer();
		AnalyzerStudy.print(analyzer);
		//3.空格分词器
		analyzer = new WhitespaceAnalyzer(Version.LUCENE_43);
		AnalyzerStudy.print(analyzer);
		//4.简单分词器
		analyzer = new SimpleAnalyzer(Version.LUCENE_43);
		AnalyzerStudy.print(analyzer);
		//5.二分法分词器
		analyzer = new CJKAnalyzer(Version.LUCENE_43);
		AnalyzerStudy.print(analyzer);
		//6.关键词分词器
		analyzer = new KeywordAnalyzer();
		AnalyzerStudy.print(analyzer);
		//7.被忽略词分词器
		analyzer = new StopAnalyzer(Version.LUCENE_43);
		AnalyzerStudy.print(analyzer);
		
		
		/*
			 分词技术：class org.apache.lucene.analysis.standard.StandardAnalyzer
			极|客|学|院|lucene|案|例|开|发|
			分词技术：class org.wltea.analyzer.lucene.IKAnalyzer
			极|客|学院|lucene|案例|开发|
			分词技术：class org.apache.lucene.analysis.core.WhitespaceAnalyzer
			极客学院，Lucene|案例|开发|
			分词技术：class org.apache.lucene.analysis.core.SimpleAnalyzer
			极客学院|lucene|案例|开发|
			分词技术：class org.apache.lucene.analysis.cjk.CJKAnalyzer
			极客|客学|学院|lucene|案例|开发|
			分词技术：class org.apache.lucene.analysis.core.KeywordAnalyzer
			极客学院，Lucene 案例 开发|
			分词技术：class org.apache.lucene.analysis.core.StopAnalyzer
			极客学院|lucene|案例|开发|
		*/

	}
}
















