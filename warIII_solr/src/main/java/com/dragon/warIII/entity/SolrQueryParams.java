package com.dragon.warIII.entity;

import org.apache.solr.client.solrj.SolrQuery.SortClause;

import java.io.Serializable;
import java.util.List;

/**
 * @description 功能描述: Solr搜索条件
 * @author 作 者: L.D
 * @createdate 建立日期：2016-10-11
 * @projectname 项目名称: warIII_solr
 * @packageclass 包及类名: com.dragon.warIII.entity  SolrQueryParams.java
 */
public class SolrQueryParams implements Serializable{

	private static final long serialVersionUID = -4449390473432828614L;

	private String queryParams;				//搜索条件
	private List<SortClause> querySort;		//搜索排序
	
	public String getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}
	public List<SortClause> getQuerySort() {
		return querySort;
	}
	public void setQuerySort(List<SortClause> querySort) {
		this.querySort = querySort;
	}
	
}
