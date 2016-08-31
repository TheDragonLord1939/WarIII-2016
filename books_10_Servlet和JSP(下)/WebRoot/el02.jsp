<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.dragon.www.unit04_1.*" %>
<html>
  <head></head>
  <body>
  	<!-- 访问Bean属性 -->
    <%
    	Course course = new Course();
    	course.setCourseId(1);
    	course.setCourseName("Servlet");
    	
    	User u1 = new User();
    	u1.setName("Luffy");
    	u1.setAge(18);
    	u1.setCourse(course);
    	u1.setInterest(new String[]{"Sleeping", "Eating"});
    	request.setAttribute("user", u1);
    %>
    <!-- 1.Java代码 -->
    <%
    	User u = (User)request.getAttribute("user");
    	out.println(u.getName());
    	out.println(u.getAge());
    %>
    <!-- 2.EL表达式 -->
   2.EL表达式1<hr1/>
   <!-- 2.1基本类型 -->
   姓名：${user.name }
   年龄：${user.age }
  	<!--2.2 引用类型 -->
  	课程名：${user.course.courseName }<br><br/>
  	
  	3.EL表达式
  	姓名：${user["name"] }
  	<%
  		request.setAttribute("userAge", "age");
  	%>
  	年龄:${user[userAge] }
  	爱好：${user.interest[1]}
  </body>
</html>
