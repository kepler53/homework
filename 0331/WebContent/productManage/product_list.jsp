<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>여기왔네</h2>
	
	<table>
	
		<thead>
			<tr>
				<td>ID</td>
				<td>상품이름</td>
				<td>수량</td>
				<td>제조사</td>
				<td>가격</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty requestScope.productList}">
			<tr>
				<td colspan="5">저장된 상품이 없습니다.</td>
			</tr>
			</c:if>
			<c:if test="${not empty requestScope.productList }">
				
				<c:forEach items="${requestScope.productList}" var = "p">
					<tr>
						<td>${p.ID}</td>
						<td>${p.productName}</td>
						<td>${p.entity}</td>
						<td>${p.manufacture}</td>
						<td>${p.price}</td>
					</tr>
				
				</c:forEach>
			</c:if>
		</tbody>
		
	
	
	</table>
	


</body>
</html>