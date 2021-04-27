<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>상품 추가</h4>
	<form action="<%=request.getContextPath()%>/add" method="post">		
		아이디 : <input type="text" name="id"><br>
		이름 : <input type="text" name="name"><br>
		가격 : <input type="number" name="price"><br>
		설명: <input type="text" name="description"><br>
		<input type="submit" value="상품추가">				
	</form>
	

</body>
</html>