<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="width" required="false" type="java.lang.Integer" description="The width of the image" %>
<%@ attribute name="stem" required="true" type="java.lang.Integer" description="The file name of the image excluding extension" rtexprvalue="true" %>
<%@ attribute name="extension" required="true" type="java.lang.Integer" description="The extension of the image" rtexprvalue="true" %>

<%-- дефолтное значение --%>
<c:if test="${empty width}">
	<c:set var="width" value="200" />
</c:if>
<b>Hello there from a custom tag: ${width}</b>

<c:set scope="page" var="imgname" value="${stem}.${extension}"></c:set>

<img width=${width} src="${pageContext.request.contextPath}/pics/${imgname}" />