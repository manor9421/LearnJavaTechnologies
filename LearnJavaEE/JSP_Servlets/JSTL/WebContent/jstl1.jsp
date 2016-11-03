<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<c:out value="Hello world jstl!"></c:out>

<jsp:useBean id="test" class="com.mnr.beans.TestBean" scope="page"></jsp:useBean>

<!-- используем переменную -->
<p>Value of info 'attribute': <c:out value="${test.info}" /></p>

<%-- Получить то, что пришло в параметре ?name=..... --%>
<p>Name parameter: <c:out value="${param.name}" /></p>
<p/>

<%-- JSTL if . Здесь == это не джавовское(а EL implicit object),
и оно может сравнивать строки.
(если параметр ?name= равен John, то покажет эту строку)--%>
<c:if test='${param.name == "John"}' >
Hello Bob
</c:if>

<c:if test='${param.name != "John"}' >
Hello there
</c:if>
<p/>

<%-- JSTL choose --%>
<c:choose>
	<c:when test="${param.id == 1}">
	<b>ID is equal to 1</b>
	</c:when>
	<c:when test="${param.id == 2}">
		<b>ID is equal to 2</b>
	</c:when>
	<c:otherwise>
		<b>ID is neither 1 nor 2</b>
	</c:otherwise>
</c:choose>
<p/>

<%-- JSTL "for" loop. Без step шаг будет 1. varStatus - переменная для статуса --%>
<c:forEach var="i" begin="0" end="10" step="2" varStatus="status" >

	<br>Loop counter is: <c:out value="${i}" /><br/>

	<!-- c:out value="${status}" /-->
	
	<%-- проверить, первая ли это итерация --%>
	<c:if test="${status.first}">
	This was the first iteration
	</c:if>
	
	<%-- проверить, последняя ли это итерация --%>
	<c:if test="${status.last}">
	This was the first iteration
	</c:if>
	
</c:forEach>





</body>
</html>