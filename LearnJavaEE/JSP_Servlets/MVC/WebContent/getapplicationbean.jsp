<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% /* application Bean переменная будет храниться В САМОЙ ПРОГРАММЕ и доступна
СО ВСЕХ КОМПЬЮТЕРОВ после своего создания во время ЭТОГО ЗАПУСКА(если перезапустить
сервер - удалится) */%>
<jsp:useBean id="user4" class="com.mnr.beans.User" scope="application" ></jsp:useBean>

Email: <%= user4.getEmail() %>
<p/>
Password: <%= user4.getPassword() %>
</body>
</html>