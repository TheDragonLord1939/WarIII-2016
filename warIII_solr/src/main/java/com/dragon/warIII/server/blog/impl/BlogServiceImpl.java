package com.dragon.warIII.server.blog.impl;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery.SortClause;

import com.dragon.warIII.entity.SearchResult;
import com.dragon.warIII.entity.SolrQueryParams;
import com.dragon.warIII.server.blog.BlogService;
import com.google.common.collect.Lists;


public class BlogServiceImpl implements BlogService{

	@Override
	public SearchResult<List<Map<String, Object>>> getSearchResult(
			Map<String, String> params, int pageNum, int pageSize) {
		
		//1.格式化参数
		//2.查询
		//2.1.设置起始的记录行数和查询的记录数
		//2.2.设置排序规则
		//2.3.设置查询参数
		//3.查询分页结果
		//3.1.获取分页集合
		//3.2.设置分页结果
		//4.返回结果集
		
		return null;
	}
	
	private SolrQueryParams formatQueryParams(Map<String, String> params) {
		List<SortClause> querySort = Lists.newArrayList();
		
		return null;
	}

}
