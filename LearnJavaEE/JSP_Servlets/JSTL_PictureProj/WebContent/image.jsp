<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%-- function prefix : http://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/fn/tld-summary.html --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%-- formatting модуль : http://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/fmt/tld-summary.html --%>
<%@ taglib tagdir="/WEB-INF/TAGS" prefix="ps" %>

<c:import url="header.jsp">
	<c:param name="title" value="Picture Squirrel - View Image"></c:param>
</c:import>



<center>

	<ps:image width="80" />
	
	<%-- в транзакциях не надо setDataSource var="ds" dataSource="jdbc/webshop" и в sql:update он тоже не надо --%>
	<sql:transaction dataSource="jdbc/webshop">
	
		<%-- Здесь =? - Вайлдкард --%>
		<sql:query sql="select * from images where id=?" var="results">
			<%-- вместо ? - наш para.image --%>
			<sql:param>${param.image}</sql:param>
		</sql:query>
		
		<%-- Получить строку и отформатировать имя --%>
		<c:set scope="page" var="image" value="${result.rows[0]}"></c:set>
		<c:set scope="page" var="imgname" value="${image.stem}.${image.image_extension}"></c:set>
		
		<c:set scope="page" var="average_ranking"
					value="${image.average_ranking}" />
		
		<%-- Ставим оценку. --%>
		<c:if test='${param.action == "rate"}'>
			<c:set scope="page" var="newRating"
				value="${(image.average_ranking * image.rankings + param.rating)/(image.rankings + 1)}" />
	
			<c:set scope="page" var="average_ranking" value="${newRating}" />
	
			<sql:update sql="update images set average_ranking=? where id=?">
				<sql:param>${newRating}</sql:param>
				<sql:param>${param.image}</sql:param>
			</sql:update>
	
			<sql:update sql="update images set rankings=? where id=?">
				<sql:param>${image.rankings+1}</sql:param>
				<sql:param>${param.image}</sql:param>
			</sql:update>
	
		</c:if>
		
	</sql:transaction>
	
	<%-- fn:substring(что,откуда,сколько). -1 - весь --%>
	<h2>
		<c:out value="${fn:toUpperCase(fn:substring(image.stem,0,1))}${fn:substring(image.stem,1,-1)}"/>
	</h2>
	<span class="rating">Rated: <fmt:formatNumber value="${average_ranking}" maxFractionDigits="1"/></span>
	
	
	
	
	
	<table style="border: none; ">
		<tr>
			<td><br style="margin-bottom: 1px;">
			<span class="attribution">Image by <a class="attribution" target="_blank" href="${image.attribution_url}">${image.attribution_name}</a></span><br/>
						
			<img width="80" src="${pageCount.request.contextPath}/images/${imgname}" />
			
			</td>
			<td>
				<form action='<c:url value="/gallery" />' method="post">
					<input type="hidden" name="action" value="rate" />
					<input type="hidden" name="image" value="${image.id}" />
		
					<table style="padding: 20px; border: none;">
						<tr>
							<td>
								<h3><i>Rate It!</i></h3>
							</td>
						</tr>
						<tr>
							<td align="left">
								<input type="radio" name="rating" value="5">5 - Amazing</input>
							</td>
						</tr>
						<tr>
							<td align="left">
								<input type="radio" name="rating" value="4">4 - Good</input>
							</td>
						</tr>
						<tr>
							<td align="left">
								<input type="radio" name="rating" value="3" checked="checked">3 - Average</input>
							</td>
						</tr>
						<tr>
							<td align="left">
								<input type="radio" name="rating" value="2">2 - Bad</input>
							</td>
						</tr>
						<tr>
							<td align="left">
								<input type="radio" name="rating" value="1">1 - Horrendous</input>
							</td>
						</tr>
						<tr>
							<td align="left">
								<input type="submit" name="submit" value="OK"></input>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</center>
<c:import url="footer.jsp"></c:import>