<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
</head>
<body>
	<h2>하고싶은 일을 선택하세요</h2>
	<a href="${pageContext.request.contextPath}/MainServlet?act=list">전체 상품 보여주기</a>
	<a href="${pageContext.request.contextPath}/MainServlet?act=addForm">상품 추가</a>
	<a href="${pageContext.request.contextPath}/MainServlet?act=deleteForm">상품 삭제</a>
</body>
</html>