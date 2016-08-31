<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>课程列表示例</title>
		<style type="text/css"></style>
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
	</head>
	<style type="text/css">
		#cz span {
			text-decoration: underline;
			color:blue;
			cursor: pointer;
		}
	</style>
	<script type="text/javascript">
	</script>
	<body>
		<table border="1">
			<tr>
				<td>课程号</td>
				<td>课程</td>
				<td>教师号</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${courses }" var="course">
			<tr>
				<td>${course.cNo }</td>
				<td>${course.cName }</td>
				<td>${course.tNo }</td>
				<td id="cz"><span>新增</span>&nbsp;<span>删除</span>&nbsp;<span>修改</span></td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>  