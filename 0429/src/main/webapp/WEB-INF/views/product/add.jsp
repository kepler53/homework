<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="root" value="${pageContext.request.contextPath}" />      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가</title>
</head>
<body>

<h2>상품추가</h2>

<form action="${root}/add" method="post">
	상품 이름 : <input type="text" name="name"><br>
	상품 가격 : <input type="number" name="price"><br>
	상품 설명 : <input type="text" name="desc"><br>
	<input type="submit" value="상품 추가">
</form>

</body>
</html>