<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>상품 목록</h2>
<c:choose>
		<c:when test="${empty pList}">
			<h2>저장된 상품이 존재하지않습니다.</h2>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>가격</th>
					<th>설명</th>
				</tr>
				<c:forEach items="${pList}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.name}</td>
						<td>${p.price}</td>
						<td>${p.description}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<a href="<%=request.getContextPath()%>/add">[상품추가]</a>
</body>
</html>