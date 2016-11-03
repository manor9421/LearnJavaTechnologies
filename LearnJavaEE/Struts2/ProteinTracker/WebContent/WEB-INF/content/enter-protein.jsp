<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter Protein</h1>
	
	<s:form>
		<s:textfield name="enteredProtein" />
		<s:submit value="Enter" />
	</s:form>
	
	<div>Last amount entered:<s:property value="enteredProtein" /></div>
	<div>Total for the day: 100g</div>
	<div><s:property value="goalText" /></div>
</body>
</html>