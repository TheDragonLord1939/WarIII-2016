<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
	<head>
		<title>Index</title>
	</head>
	<body>
		<h1>hello <shiro:principal></shiro:principal></h1>
		<shiro:guest>
			<a href="/shiro-first/login">用户登录</a>
		</shiro:guest>
		<shiro:user>
			<a href="/shiro-first/user/list.jsp">用户列表</a>
			<shiro:hasPermission name="user:add">
				<a href="/shiro-first/user/add.jsp">用户添加</a>
			</shiro:hasPermission>
			<shiro:hasRole name="admin">
				<a href="/shiro-first/admin">管理界面</a>
			</shiro:hasRole>
			<a href="/shiro-first/logout">退出系统</a>
		</shiro:user>
	</body>
</html>  