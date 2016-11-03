<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import ="java.util.Date, com.mnr.gui.*" %> <!--  подключаем две страницы -->

<%= new Date() %>

<%
TextOutput textOutput = new TextOutput();
 out.println(textOutput.getInfo());

%>

</body>
</html>

<!-- %= new java.util.Date() %>

 -->
 
 
 
 
 <!-- 
 В web.xml:
<servlet>
	<servlet-name>MyServlet</servlet-name>
	<servlet-class>com.mnr.MyServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>MyServlet</servlet-name>
	<url-pattern>/test</url-pattern>
</servlet-mapping>
 
<servlet>
	<servlet-name>Login</servlet-name>
	<jsp-file>/Login.jsp</jsp-file> - какой файл
</servlet>
<servlet-mapping>
	<servlet-name>Login</servlet-name>
	<url-pattern>/LoginPage</url-pattern>
</servlet-mapping>
 
  -->