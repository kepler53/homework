<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="root" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어떤 걸로 갈까</title>
</head>
<body>

<a href="${root}/add">[상품 추가]</a>
<a href="${root}/list">[상품 목록 보기]</a>

<script type="text/javascript">
	let msg = '${addSuccessMsg}'
	if(msg){
		alert(msg);
	}
</script>
</body>
</html>