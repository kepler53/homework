<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="root" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h2{
	text-align: center;
}
.login-input{
	text-align: right;
}
</style>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>

<h2>이종현의 판매장</h2>

<div class="login-input">
	<form action="${root}/login" method="post">
		<input type="text" placeholder="ID를 입력하세요" name="userid">
		<input type="password" name="userpass">
		<input type="submit" value="Login">
	</form>
</div>

<script type="text/javascript">
	let msg = "${loginFailMsg}";
	if (msg) {
		alert(msg);
	}
</script>

</body>
</html>