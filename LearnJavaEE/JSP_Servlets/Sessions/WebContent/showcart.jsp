<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="com.mnr.demo.*" %>

<% Cart cart = (Cart)session.getAttribute("cart"); %>

Items in cart: <%= cart == null ? "error" : cart.getTotalItems() %>
<!-- то же, что и обычная ссылка, которая была до этого -->
<a href="<%=response.encodeUrl(request.getContextPath()) + "/showcart2.jsp" %>">Click here</a>


</body>
</html>