<%@page import="java.sql.DriverManager"%>
<%@page import="com.mnr.beans.Book"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="com.mnr.database.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- заголовок --%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Book list" />
</jsp:include>

<c:choose>
	<c:when test="${cookie.containsKey('user')}">
		<div>Hello, ${cookie.user.getValue()}</div>
		<div><a href="/FinalProject/Connector?action=logout">Logout</a></div>
	</c:when>
	<c:otherwise>
		<a href="/FinalProject/login.jsp">Login</a>
	</c:otherwise>
</c:choose>

<a href="/FinalProject/addbook.jsp">Add new book</a>

<%

	DBConnection dbConnection = new DBConnection();
	
	try {
	    Connection  connection = dbConnection.getConnection();
	    
	    if(!connection.isClosed()){
	    	Book[] books = dbConnection.findBooks(connection);
	    	pageContext.setAttribute("bookList", books);// делаем переменную видимой для jstl
	    	
	    	connection.close();
	    }
	}catch(Exception ex){
	    out.println("Unable to connect db: "+ex);
	}
	
%>

<c:forEach var="book" items="${bookList}">
	<div class="book_div">
		<p class="book_name">Name: ${book.getName()}</p>
		<p class="book_author">Author: ${book.getAuthor()}</p>
		<p class="book_price">Price: ${book.getPrice()}</p>
		<p class="book_id">id: ${book.getId()}</p>
	</div>
</c:forEach>







<jsp:include page="footer.jsp" />