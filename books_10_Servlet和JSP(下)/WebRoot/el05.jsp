<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.dragon.www.unit04_1.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>
<html>
  <head></head>
  <body>
  <%
  	User user = new User();
  	user.setName("liuliu");
  	user.setAge(17);
  	request.setAttribute("user",user);
  %>
  	<c:choose>
  		<c:when test="${user.age < 18}">未成年</c:when>
  		<c:when test="${user.age < 18}">未成年</c:when>
  		<c:otherwise>成年</c:otherwise>
  	</c:choose>
  </body>
</html>
