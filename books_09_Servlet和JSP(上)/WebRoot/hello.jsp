<%@page pageEncoding="UTF-8" %>
<html>
	<head></head>
	<body style="font-size:24px">
		<%--使用out.print("Hello JSP");方式输出 --%>
		<%
			for(int i=0; i<10; i++) {
				out.println("Hello JSP<br>");
			}
		%>
		<hr>
		<h1>******************************************</h1>
		<!-- 使用 <%="Hello JSP"%>方式输出-->
		<%
			for(int i=0; i<10; i++){
		%>
			<%="No."+(i+1)+"Hello JSP" %><br>
		<%
		 }
		%>
	</body>
</html>