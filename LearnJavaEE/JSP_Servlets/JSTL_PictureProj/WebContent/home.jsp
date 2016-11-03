<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql" %>

<c:import url="header.jsp">
<%-- задал переменную, которую потом вставим в заголовок --%>
<c:param name="title" value="Picture Squirrel Home"></c:param>
</c:import>


Content goes here

<sql:setDataSorce var="ds" dataSource="jdbc/webshop" />

<sql:query dataSource="${ds}" sql="SELECT * FROM images LIMIT 10" var="results" />

<table class="images">

<c:set var="tablewidth" value="8" />
	
	<c:forEach var="image" items="${results.rows}" varStatus="row" >

		<c:if test="${row.index % tablewidth == 0}" >
		<tr>
		</c:if>
		
			<%-- столбец stem и image_extension из таблицы image. '.' - просто часть строки --%>
			<c:set scope="page" var="imagename" value="${image.stem}.${image.image_extension}" ></c:set>
		
			<td>
			
				<a href="<c:url value="/gallery?action=image&image=${image.id}" />">
					<img width="80" src="${pageContextrequest.contextPath}/images/${imagename}"/>
				</a>
			</td>
			
		<c:if test="${row.index % tablewidth == 0}" >
		</tr>
		</c:if>
	
	</c:forEach>
</table>


<c:import url="footer.jsp"></c:import>
