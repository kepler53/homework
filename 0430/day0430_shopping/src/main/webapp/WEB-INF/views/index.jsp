<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="root" value="${pageContext.request.contextPath}" />  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
	h1{
		text-align: center;
		margin-bottom: 25px;
	}
	
	.login-form{
		text-align: center;
	}
	#login-btn{
		padding: 15px 84.5px;
		margin-bottom: 15px;
	}
	.input{
		padding : 8px 20px;
		margin-bottom: 15px;
	}
</style>
<title>Insert title here</title>
</head>
<body>

<h1>lee mall</h1>

<div class="login-form">
<form action="${root}/login" method="post">
	<input type="text" name="id" placeholder="아이디" class="input"><br>
	<input type="password" name="pwd" placeholder="비밀번호" class="input"><br>
	<input type="submit" value="로그인" id="login-btn">
</form>

<a href="${root}/addMember">회원가입</a>
</div>
</body>
</html>