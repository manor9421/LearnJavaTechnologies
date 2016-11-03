<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user5" class="com.mnr.beans.User" scope="page"></jsp:useBean>

<% /* хватает параметр ?pw=..., с которым мы пришли на страницу(?pw=123 - возьмет 123 и сохранит в password user5) */ %>
<jsp:setProperty property="password" name="user5" param="pw" />

<!-- jsp:setProperty name="user5" property="*" /> - сохранит переменные, подставив вместо property те, которые пршли( ?email=john@a.com&password=123 - email=John,password=123)
использовать можно для форм
< % = user5.getEmail() % >
< % = user5.getPassword() % >
-->

<%= user5.getPassword() %>

</body>
</html>