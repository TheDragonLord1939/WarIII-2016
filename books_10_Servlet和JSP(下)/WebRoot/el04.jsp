<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.dragon.www.unit04_1.* " %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>
<html>
  <head></head>
  <body>
  <%
  	User user1 = new User();
  	user1.setName("liuliu");
  	user1.setAge(17);
  	request.setAttribute("user",user1);
  	
  	User user2 = new User();
  	user2.setName("liuliuliuliuliuliu");
  	user2.setAge(17343);
  	request.setAttribute("user",user2);
  	
  	List<User> users = new ArrayList<User>();
  	users.add(user1);
  	users.add(user2);
  	request.setAttribute("users", users);
  %>
  <c:forEach items="${users }" var="user" varStatus="s">
  	${user.name }
  	${user.age }
  	count:${s.count }
  	index:${s.index }</br>
  </c:forEach>
  	
  </body>
</html>
