<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 추가</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/MainServlet" method="post">
	ID : <input type="text" name="id"><br>
	상품이름 : <input type="text" name="productname"><br>
	수량 : <input type="text" name="entity"><br>
	제조사 : <input type="text" name="manufacture"><br>
	가격 : <input type="text" name="price"><br>
	<input type="hidden" name="act" value="add">
	<input type="submit" value="상품추가">
	</form>
</body>
</html>