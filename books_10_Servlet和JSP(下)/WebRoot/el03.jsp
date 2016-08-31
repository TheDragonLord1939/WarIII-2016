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
  	if标签:<hr/>
  	<c:if test="${user.age >= 18}" var="rs">
  		成年，可以进入.
  	</c:if>
  	<c:if test="${!rs }">
  		未成年，不可进入.
  	</c:if>
  </body>
</html>
