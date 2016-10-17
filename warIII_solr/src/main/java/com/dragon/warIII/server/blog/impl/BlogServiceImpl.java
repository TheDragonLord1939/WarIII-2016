package com.dragon.warIII.server.blog.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dragon.warIII.entity.SearchResult;
import com.dragon.warIII.entity.SolrQueryParams;
import com.dragon.warIII.server.blog.BlogService;
import com.dragon.warIII.utils.SolrTool;
import com.dragon.warIII.utils.string.StringUtils;
import com.google.common.collect.Lists;

@Service("bolgService")
public class BlogServiceImpl implements BlogService{

	@Autowired
	@Qualifier("solrTools")
	private SolrTool solrTool;
	
	@Override
	public SearchResult<List<Map<String, Object>>> getSearchResult(
			Map<String, String> params, int curPage, int pageSize) {
		
		//1.格式化参数
		SolrQueryParams solrParams = formatQueryParams(params);
		
		//2.查询
		SolrQuery solrQuery = new SolrQuery();
		//2.1.设置起始的记录行数和查询的记录数
		solrQuery.setStart((curPage<1)?0: (curPage - 1)*pageSize).setRows(pageSize);
		//2.2.设置排序规则
		solrQuery.setSorts(solrParams.getQuerySort());
		//2.3.设置查询参数
		solrQuery.setQuery(appendKeyWord(params, solrParams));
		
		//3.查询分页结果
		SearchResult<List<Map<String, Object>>> result = new SearchResult<List<Map<String, Object>>>();
		//3.1.获取分页集合
		result = SolrTool.searchList(solrQuery);
		//3.2.设置分页结果
		result.setPageSize(pageSize);	//每页记录条数
		result.setCurPage(curPage);		//当前页数
		if(result != null && result.getTotal() > 0 && pageSize > 0) {
			int c = result.getTotal() / pageSize;
			result.setCountPages(result.getTotal() % pageSize == 0 ? c : c+1);	//总共页数
		}
		if(StringUtils.isEmpty(result.getRecord())) {
			result.setRecord(new ArrayList<Map<String, Object>>());
		}
		
		//4.返回结果集
		return result;
	}
	
	private SolrQueryParams formatQueryParams(Map<String, String> params) {
		List<SortClause> querySort = Lists.newArrayList();
		StringBuffer queryParams = new StringBuffer();
		SolrQueryParams solrParams = new SolrQueryParams();
		
		//1.搜索参数
		if (StringUtils.isNotBlank(params.get("author"))) {
			queryParams.append(solrTool.format("AND author:[]", params.get("author")));
		}
		if (StringUtils.isNotBlank(params.get("city"))) {
			queryParams.append(solrTool.format("AND city:[]", params.get("city")));
		}
		
		//2.排序规则
		if(StringUtils.isNotBlank(params.get("id"))) {
			querySort.add(new SortClause("id", SolrQuery.ORDER.asc));
		}
		
		solrParams.setQueryParams(queryParams.toString());
		solrParams.setQuerySort(querySort);
		return solrParams;
	}
	
	private String appendKeyWord(Map<String, String> params, SolrQueryParams solrParams) {
		String queryString = solrParams.getQueryParams();
		if(StringUtils.isNotBlank(params.get("keyWord"))) {
			queryString = "*:*".concat(queryString);
		} else {
			queryString = "simpleGroup:\"" + ClientUtils.escapeQueryChars(StringUtils.format("{}", "\\{\\}", params.get("keyWord"))).concat("\"").concat(queryString);
		}
		return queryString;
	} 

}
