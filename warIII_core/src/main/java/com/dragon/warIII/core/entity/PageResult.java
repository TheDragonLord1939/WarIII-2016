package com.dragon.warIII.core.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * @description 功能描述: 分页数据对象
 * @author 作 者: L.D
 * @date 建立日期：2016-6-26
 * @name 项目名称: warIII_core
 * @package 包及类名: com.dragon.warIII.entity   PageResult.java
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public class PageResult extends BaseEntity{
	
	private static final long serialVersionUID = -9137998693732939769L;
	
	private Integer total = 0; 					// 总页数
	private List<?> rows = new ArrayList<>();   // 记录集
	private String more ="";					// 是否有更多
	private Integer curPage = 1;				// 当前页数
	private Integer countpages = 1;				// 总共页数
	private Integer pageSize = 20;				// 每页记录条数
	private Integer first = 0;					// 从{}条记录开始显示
	private Integer last = 0;					// 到{}记录结束

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getCountpages() {
		return countpages;
	}

	public void setCountpages(int countpages) {
		this.countpages = countpages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}


	/**
	 * <p>计算页数和起始记录条数</p>
	 * @param curPage
	 * @param pageSize
	 * @param total  
	 */
	public void pagination(int curPage,int pageSize,int total) {
		// 每页最多200条记录
		pageSize = pageSize > 200 ? 200 : pageSize;
		// 计算总页数
		if (total % pageSize == 0) {
			countpages = total / pageSize;
		} else {
			countpages = total / pageSize + 1;
		}
		// 判断页数是否超出范围
		if (curPage < 1 || countpages == 0){
			curPage = 1;
		}
		/*if (countpages != 0 && curPage > countpages)
			curPage = countpages;*/
		// 设置信息从第几条记录开始
		first = pageSize * (curPage - 1)+1;
		this.setFirst(first);
		this.setLast(total-first>=pageSize?pageSize:total-first);
		this.setCountpages(countpages);
		this.setCurPage(curPage);
		this.setTotal(total);
		this.setMore(String.valueOf(curPage<countpages));
		this.setPageSize(pageSize);
	}
}
