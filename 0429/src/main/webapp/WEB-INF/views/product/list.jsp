<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="root" value="${pageContext.request.contextPath}" />        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
</head>
<body>

<h2>목록</h2>

<c:choose>
	<c:when test="${empty pList}">
		상품이 존재하지않습니다..
	</c:when>
	<c:otherwise>
		<table border="1">
			<tr>
				<th>이름</th>
				<th>가격</th>
				<th>설명</th>
			</tr>
			<c:forEach items="${pList}" var="p">
			<tr>
				<td>${p.name}
				<td>${p.price}
				<td>${p.descript}
			</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>

<a href="${root}/function">[기능 페이지로 돌아가기]</a>

</body>
</html>