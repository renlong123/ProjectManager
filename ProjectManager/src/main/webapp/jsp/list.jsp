<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style="text-align: center">商品信息查看</h2>
	<div style="text-align: center">
		<table style="border:1px;cellspacing:1px">
		<c:forEach items="${list }" var="s" >
			<tr>
				<%-- <td>${list } <%=request.getAttribute("list") %></td> --%>
				<td><c:out value="${s.id }"></c:out></td>
				<td><c:out value="${s.name }"></c:out></td>
				<td><c:out value="${s.price }"></c:out></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>