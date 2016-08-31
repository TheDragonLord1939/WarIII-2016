<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>学生列表示例</title>
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
		$("table").click(function() {
			debugger;
			alert("fuck you ...")
		});
	</script>
	<body>
		<table border="1">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>性别</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${students }" var="student">
			<tr>
				<td>${student.sno }</td>
				<td>${student.sname }</td>
				<td>${student.sage }</td>
				<td>${student.ssex }</td>
				<td id="cz"><span>新增</span>&nbsp;<span>删除</span>&nbsp;<span>修改</span></td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>  