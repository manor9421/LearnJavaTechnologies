<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- static include - ЕСЛИ файл меняется редко -->
<%@ include file="copyright.txt" %> 

<p/>

<!-- dynamic include - постоянно меняется -->
<jsp:include page="updates.txt" />

<!-- Нужно делать статик инклуд, если это ДЖАВА КОД -->
<%@ include file="variables.jsp" %>
<p/>
<%=name%> <!-- переменная из приИнклуженного файла  -->
<p/>]
<!-- Использовать инклуд-ТЭГ, если неизвестно какой файл нужен ДО рантайма -->
<% String id = request.getParameter("id"); %>
<% if(id==null){ %>
<jsp:include page="idnotfound.html" />
<% }else{ %>
<jsp:include page="idfound.html" />
<% } %>

</body>
</html>