<jsp:include page="header.jsp">
	<jsp:param name="title" value="Login"/>
</jsp:include>

<%

if(request.getAttribute("result") != null){
	out.print("<div class='resultMessage'>"
			+ request.getAttribute("result")
			+ "</div>");
}

%>

<form action="/FinalProject/Connector" method="POST">
	<input type="hidden" name="action" value="login_user"/>
	<input type="text" name="login"/><br/>
	<input type="password" name="password"/><br/>
	<input type="submit" value="OK"/>  
</form>

<div><a href="/FinalProject/register.jsp">Registration</a></div>


<jsp:include page="footer.jsp"/>