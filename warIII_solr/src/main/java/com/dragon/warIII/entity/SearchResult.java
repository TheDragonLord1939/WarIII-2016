package com.dragon.warIII.entity;

import java.io.Serializable;

/**
 * @description 功能描述: 搜索结果集
 * @author 作 者: L.D
 * @createdate 建立日期：2016-10-11
 * @projectname 项目名称: warIII_solr
 * @packageclass 包及类名: com.dragon.warIII.entity  SearchResult.java
 */
public class SearchResult<T> implements Serializable{

	private static final long serialVersionUID = -6268672695542954925L;

	private T record;				//1.结果集
	private Integer total = 0;		//2.查询的记录总数
	
	private Integer curPage = 1;	//3.当前页数
	private Integer countPages = 1;	//4.总共页数
	private Integer pageSize = 20;	//5.每页记录条数
	
	public T getRecord() {
		return record;
	}
	public void setRecord(T record) {
		this.record = record;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getCountPages() {
		return countPages;
	}
	public void setCountPages(Integer countPages) {
		this.countPages = countPages;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
