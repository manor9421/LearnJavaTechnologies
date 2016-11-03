<%-- заголовок --%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Book list" />
</jsp:include>

<%
if(request.getAttribute("result") != null){
	out.print("<div class='resultMessage'>"
		+ request.getAttribute("result")
		+ "</div>");
}

%>

<form action="/FinalProject/Connector" method="POST">
	<input type="hidden" name="action" value="addbook" />
	Name: <input type="text" name="book_name"/><br/>
	Author: <input type="text" name="book_author"/><br/>
	Price: <input type="text" name="book_price"/><br/>
	<input type="submit" value="Confirm"/>
</form>

<jsp:include page="footer.jsp"/>