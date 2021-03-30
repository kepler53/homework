<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.member.MemberDto"%>
    
<!--     Dto import하는거 까먹지 말기 안하면 script 부분에서 오류가 남 -->
<%
String root = request.getContextPath();

MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
%>       
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마지막 프로덕트</title>
<style type="text/css">
	table{
		text-align: center;
		width: 200px;
		height : 200px;
	}
	.column1{
		font-weight: bold;
	}
</style>
</head>
<body>


<%= memberDto.getUserName() %>님 안녕하세요.<br>
<h2>당신의 마지막 물품은 다음과 같습니다.</h2><br>

<table>
	<tr>
		<td class = "column1">상품번호</td>
		<td class = "column">Smart_TV</td>
	</tr>
	<tr>
		<td class = "column1">상품명</td>
		<td class = "column">s7</td>
	</tr>
	<tr>
		<td class = "column1">상품가격</td>
		<td class = "column">5000</td>
	</tr>
	<tr>
		<td class = "column1">상품설명</td>
		<td class = "column">65인치tv</td>
	</tr>
</table>
<a href="">상품수정</a>
<a href="">상품삭제</a>
<a href="">상품목록</a>

</body>
</html>