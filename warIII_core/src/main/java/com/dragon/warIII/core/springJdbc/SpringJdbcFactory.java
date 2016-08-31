package com.dragon.warIII.core.springJdbc;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dragon.warIII.core.entity.PageResult;
import com.dragon.warIII.core.log.AsyncLogRecord;
import com.dragon.warIII.utils.string.StringUtils;

@Component
public class SpringJdbcFactory {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	/**-----------------------执行SQL语句,返回列表--------------------*/
	/**
	 * <p>执行SQL语句,返回列表</p>
	 * @param sql
	 * @param params
	 * @return  
	 */
	public List<Map<String,Object>> queryForList(final String sql,LinkedHashMap<String,Object> params) {
		return this.queryForList(sql,convertLinkedHashMap(params));
	}
	
	/**
	 * <p>执行SQL语句，返回列表</p>
	 * @param sql
	 * @param args
	 * @return  
	 */
	public List<Map<String,Object>> queryForList(final String sql,Object... args) {
		return this.jdbcTemplate.queryForList(sql,args);
	}
	
	/**
	 * <p>将Map转换成Object数组</p>
	 * @param params
	 * @return  
	 */
	public Object[] convertLinkedHashMap(LinkedHashMap<String, Object> params) {
		if(StringUtils.isEmpty(params)) {
			return null;
		}
		Object[] args = new Object[params.size()];
		int i=0;
		for(String key : params.keySet()) {
			args[i++] = params.get(key);
		}
		return args;
	}
	
	
	/**-----------------------分页查询1--------------------*/
	/**
	 * <p>分页查询</p>
	 * @param sql
	 * @param curPage
	 * @param pageSize
	 * @param params
	 * @return  
	 */
	public PageResult queryForPage(final String sql,Integer curPage,Integer pageSize ,LinkedHashMap<String, Object> params) {
		return this.queryForPage(sql, curPage, pageSize, this.convertLinkedHashMap(params));
	}
	
	public PageResult queryForPage(final String sql,Integer curPage,Integer pageSize ,Object ...args) {
		PageResult page = new PageResult();
		try {
			page.setTotal(this.jdbcTemplate.queryForObject(StringUtils.getCountSqlChild(sql), Integer.class,args));
		} catch (DataAccessException e) {
			e.printStackTrace();
			page.setTotal(0);
			
		}
		page.pagination(curPage, pageSize, page.getTotal());
		if(page.getTotal() == 0) {
			return page;
		}
		page.setRows(
			this.jdbcTemplate.queryForList(new OracleDialect().getPaginationSql(sql, page.getCurPage(), page.getPageSize()),args)
		);
		return page;
	}
	
	/**-----------------------分页查询2--------------------*/
	/**
	 * <p>分页查询</p>
	 * @param sql 查询SQL
	 * @param curPage 当前页码
	 * @param pageSize 每页记录条数
	 * @param args 查询条件
	 * @return
	 */
	public PageResult queryForPageChild(final String sql,Integer curPage,Integer pageSize ,Object ...args) {
		
		AsyncLogRecord.getInstance().info("原始SQL:"+StringUtils.format(sql, "\\?", args), this.getClass());
		AsyncLogRecord.getInstance().info("参数列表:"+args==null||args.length<=0?null:Arrays.toString(args), this.getClass());
		
		PageResult page = new PageResult();
		AsyncLogRecord.getInstance().info("count SQL:"+StringUtils.format(StringUtils.getCountSqlChild(sql), "\\?", args), this.getClass());
		page.setTotal(this.jdbcTemplate.queryForObject(StringUtils.getCountSqlChild(sql), Integer.class,args));
		// 如果当前页数大于总页数，则取总页数为当前页数
		curPage = curPage>page.getTotal()?page.getTotal():curPage;
		page.pagination(curPage, pageSize, page.getTotal());
		if(page.getTotal() == 0) {
			return page;
		}
		AsyncLogRecord.getInstance().info("分页  SQL:"+StringUtils.format(new OracleDialect().getPaginationSql(sql, page.getCurPage(), page.getPageSize()), "\\?", args), this.getClass());
		page.setRows(
			this.jdbcTemplate.queryForList(new OracleDialect().getPaginationSql(sql, page.getCurPage(), page.getPageSize()),args)
		);
		return page;
	}
	
	/**-----------------------返回一个Map对象--------------------*/
	/**
	 * <p>返回一个Map对象</p>
	 * @param sql
	 * @param args
	 * @return  
	 */
	public Map<String,Object> queryForMap(final String sql ,Object ...args) {
		return this.jdbcTemplate.queryForMap(sql,args);
	}
	
}
