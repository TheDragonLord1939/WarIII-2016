package com.dragon.war.boot.monitor;

import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;
import javax.servlet.annotation.WebInitParam;

/**
 * @description 功能描述: Druid数据源状态监控.
 * @author 作 者: L.D
 * @createdate 建立日期：2016-10-12
 * @projectname 项目名称: SpringBoot-007-Hibernate
 * @packageclass 包及类名: com.dragon.war.boot.monitor  DruidStatViewServlet.java
 */
@WebServlet(urlPatterns = "/druid/*",
initParams = {
	@WebInitParam(name = "allow", value = "192.168.1.72,127.0.0.1"),// IP白名单
			@WebInitParam(name = "deny", value = "192.168.1.73"),// IP黑名单
			@WebInitParam(name = "loginUsername", value = "yl2012"),// 用户名
			@WebInitParam(name = "loginPassword", value = "yl.Q.ACL"),// 密码
			@WebInitParam(name = "resetEnable", value = "false") // 禁用HTML页面上的"Reset All"功能
	}
)
public class DruidStatViewServlet extends StatViewServlet {

	private static final long serialVersionUID = 4655715799221777363L;

}
