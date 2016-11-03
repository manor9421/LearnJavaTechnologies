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

<%-- из PassObject, которые мы определили --%>
<c:out value="${user1.name}" /><br/>
<c:out value="${user2.name}" /><br/>
<c:out value="${user3.name}" /><br/>

<c:out value="${sessionScope.user2.name}" /><br/>

<!-- pageContext information - c:out value="${pageContext.out}"-->

<%-- тот map1, что приходит с реквестом из PassObject --%>
<c:out value='${map1["fruit"]}' /><br/>

<%-- выведет как текст. Чтобы было как положенно(аттрибуты не выводились, как текст) - писать без c:out --%>
<c:out value="${link}" /><br/>
${link}<br/>

</body>
</html>