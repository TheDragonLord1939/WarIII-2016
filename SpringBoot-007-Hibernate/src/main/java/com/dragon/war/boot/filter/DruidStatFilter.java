package com.dragon.war.boot.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @description 功能描述: Druid过滤器.
 * @author 作 者: L.D
 * @createdate 建立日期：2016-10-12
 * @projectname 项目名称: SpringBoot-007-Hibernate
 * @packageclass 包及类名: com.dragon.war.boot.filter  DruidStatFilter.java
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
	initParams = {
	@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") // 忽略资源
	}
)
public class DruidStatFilter extends WebStatFilter {
	
}