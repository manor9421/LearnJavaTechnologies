<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% /* задаем переменные для ЕДИНСТВЕННОГО ПЕРЕХОДА, ее увидит только страница редиректа */ %>
<jsp:useBean id="user3" class="com.mnr.beans.User" scope="request"></jsp:useBean>
<% /* для сеттеров */ %>
<jsp:setProperty name="user3" property="email" value="roman@g.ua"/>
<jsp:setProperty name="user3" property="password" value="1234"/>

<% /*response.sendRedirect("getrequestbean.jsp"); - НЕ увидит наши переменные*/%>

<jsp:forward page="getrequestbean.jsp"></jsp:forward>

</body>
</html>