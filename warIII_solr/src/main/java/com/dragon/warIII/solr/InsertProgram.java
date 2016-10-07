package com.dragon.warIII.solr;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

/**
 * @description 功能描述: 测试Solr简历索引
 * @author 作 者: L.D
 * @createdate 建立日期：2016-9-15
 * @projectname 项目名称: warIII_solr
 * @packageclass 包及类名: com.dragon.warIII.solr  InsertProgram.java
 */
public class InsertProgram {

	//Solr服务器地址
	private static final String solrServerUrl = "http://192.168.137.100:8080/solr";
	
	//Solrhome下的core
	private static final String solrCoreHome = "my_solr";
	
	//待索引、查询字段
	public static String[] docs = {"Solr是一个独立的企业级搜索应用服务器",
		"她对外提供类似于Web-service的API接口",
		"用户可以通过Http请求",
		"向搜索引擎服务器提交一定格式的XML问价生成索引",
		"也可以通过Http Get操作提出查找请求",
		"并得到XML格式的返回结果"};
	
	public static void main(String[] args) {
		System.out.println("create index start...");
		SolrClient client = getSolrClient();
		int i = 0;
		List<SolrInputDocument> solrDocs = new ArrayList<SolrInputDocument>();
		for (String content : docs) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", i++);
//			doc.addField("title", content);
			doc.addField("context_test", content);
			solrDocs.add(doc);
		}
		try {
			client.add(solrDocs);
			client.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("create index end.");
	}
	
	public static SolrClient getSolrClient() {
		
//		return new HttpSolrClient(solrServerUrl + "/" + solrCoreHome); 
//		无语了,就是用不了.
		return (new HttpSolrClient.Builder(solrServerUrl + "/" + solrCoreHome)).build();
	}
}










