package com.dragon.warIII.utils;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import com.sun.xml.internal.messaging.saaj.client.p2p.HttpSOAPConnectionFactory;

/**
 * @description 功能描述: Solr工具类
 * @author 作 者: L.D
 * @createdate 建立日期：2016-10-8
 * @projectname 项目名称: warIII_solr
 * @packageclass 包及类名: com.dragon.warIII.util  SolrTool.java
 */
@Component("solrTool")
public class SolrTool {

	private static final Logger log = LoggerFactory.getLogger(SolrTool.class);
	
	public static final ResourceBundle rb = ResourceBundle.getBundle("solr");
	private static final String SOLR_SERVICE_URL = rb.getString("solr.server.url");
	public static final String DEFAULT_CORE_NAME = rb.getString("solr.server.core.home");
	
	public SolrTool() {
	}
	
	private static HttpSolrClient httpSolrClient;
	
	public static SolrClient getSolrClient() {
		try {
			if (httpSolrClient == null) {
				
				httpSolrClient = (new HttpSolrClient.Builder(SOLR_SERVICE_URL + "/" + DEFAULT_CORE_NAME)).build();
				
				//1.设置超时时间
				httpSolrClient.setSoTimeout(Integer.valueOf(rb.getString("soTimeOut")));
				httpSolrClient.setConnectionTimeout(Integer.valueOf(rb.getString("connectionTimeout")));
				//2.设置最大连接数
				httpSolrClient.setDefaultMaxConnectionsPerHost(Integer.valueOf(rb.getString("defaultMaxConnectionsPerHost")));
				httpSolrClient.setMaxTotalConnections(Integer.valueOf(rb.getString("maxTotalConnections")));
				//3.连接失败是否重新连接
				// 连接失败是否重新连接
				httpSolrClient.setFollowRedirects(true); // defaults to false
				//4.是否允许压缩(要求服务器支持GZIP)
				httpSolrClient.setAllowCompression(true);
				//5.连接失败的重试次数
			}
		} catch (Exception e) {
			log.error("Solr服务器连接失败,失败原因:" + e.getMessage(), e);
		}
		return httpSolrClient;
	}
	
	/**
	 * <p>1.批量添加索引</p>
	 * @param dataBeanList	要添加的索引列表,数据必须是索引Bean
	 */
	/**
	 * @param dataBeanList
	 */
	/**
	 * @param dataBeanList
	 */
	/**
	 * @param dataBeanList
	 */
	public static void add(List<?> dataBeanList) {
		try {
			getSolrClient().addBeans(dataBeanList);
		} catch (Exception e) {
			log.error("Solr批量添加索引失败,失败原因:" + e.getMessage(), e);
		}
	}
		
	/**
	 * <p>2.添加单条索引</p>
	 * @param dataBean
	 */
	public static void add(Object dataBean) {
		try {
			getSolrClient().addBean(dataBean);
		} catch (Exception e) {
			log.error("Solr添加单条索引失败,失败原因:" + e.getMessage());
		}
	}
	
	/**
	 * <p>3.删除全部索引</p>
	 */
	public static void deleteAll() {
		try {
			getSolrClient().deleteByQuery("*:*", 500);
		} catch (Exception e) {
			log.error("Solr删除全部索引失败,失败原因:" + e.getMessage(), e);
		}
	}
	
	/**
	 * <p>4.批量删除索引</p>
	 * @param beanIds	要删除的索引ID集合
	 */
	public static void delete(List<String> beanIds) {
		try {
			getSolrClient().deleteById(beanIds);
		} catch (Exception e) {
			log.error("Solr批量删除索引失败,失败原因:" + e.getMessage(), e);
		}
	}
	
	/**
	 * <p>5.根据ID,删除单条索引</p>
	 * @param beanId	要删除的索引ID
	 */
	public static void delete(String beanId) {
		try {
			getSolrClient().deleteById(beanId);
		} catch (Exception e) {
			log.error("Solr删除单条索引失败,失败原因:" + e.getMessage(), e);
		}
	}
	
	/**
	 * <p>6.1.优化并提交索引</p>
	 * @param flag
	 */
	public static void optimize(boolean flag) {
		try {
			getSolrClient().optimize(flag, flag);
			commit();
		} catch (Exception e) {
			log.error("Solr优化并提交索引失败,失败原因:" + e.getMessage(), e);
		}
	}
	
	/**
	 * <p>6.2.提交索引</p>
	 */
	public static void commit() {
		try {
			httpSolrClient.commit(true, true);
		} catch (Exception e) {
			log.error("Solr提交索引失败,失败原因:" + e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("begin...");
		deleteAll();
		System.out.println("end...");
	}
}







