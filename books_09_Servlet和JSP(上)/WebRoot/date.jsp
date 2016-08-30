<%@page import="java.util.*, java.text.SimpleDateFormat"
	pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<div style="font-size:20px; border:1px solid red; 
			width:350px;padding:20px">
		<%
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		%>
		<%="当前系统时间"+sdf.format(date) %>
</div>