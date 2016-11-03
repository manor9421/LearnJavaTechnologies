<jsp:include page="header.jsp">
	<jsp:param value="Register" name="title"/>
</jsp:include>
<%
if(request.getAttribute("result") != null){
	out.print("<div class='resultMessage'>"
			+ request.getAttribute("result")
			+ "</div>");
}
%>
<form action="/FinalProject/Connector" method="POST">
	<input type="hidden" name="action" value="user_registration">
	<input type="text" name="login"/><br/>
	<input type="password" name="password" /><br/>
	<input type="submit" value="OK"/>
</form>


<jsp:include page="footer.jsp" />