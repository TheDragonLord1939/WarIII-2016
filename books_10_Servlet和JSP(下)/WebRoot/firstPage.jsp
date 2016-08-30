<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'firstPage.jsp' starting page</title>
  </head>
  
  <body>
    当前共有:<%=application.getAttribute("count").toString() %>人在线<br>
    <a href="logout">登出</a>
  </body>
</html>
