<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/MainServlet" method="post">
	삭제할 상품 명을 입력하세요 : <input type="text" name="deleteproductname">
	<input type="hidden" name="act" value="delete">
	<input type="submit" value="상품삭제">
	</form>

</body>
</html>