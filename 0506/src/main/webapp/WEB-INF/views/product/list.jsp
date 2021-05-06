<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="root" value="${pageContext.request.contextPath}" />        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
            $('.filedown').click(function() {
        		$(document).find('[name="sfolder"]').val($(this).attr('sfolder'));
        		$(document).find('[name="ofile"]').val($(this).attr('ofile'));
        		$(document).find('[name="sfile"]').val($(this).attr('sfile'));
        		$('#downform').attr('action', '${root}/download').attr('method', 'get').submit();
        	});
			
		});

		</script>


</head>
<body>
	<form id="downform">
		<input type="hidden" name="sfolder">
		<input type="hidden" name="ofile">
		<input type="hidden" name="sfile">
	</form> 

<h2>목록</h2>

<c:choose>
	<c:when test="${empty pList}">
		상품이 존재하지않습니다..
	</c:when>
	<c:otherwise>
		<table border="1">
			<tr>
				<th>이름</th>
				<th>가격</th>
				<th>설명</th>
			</tr>
			<c:forEach items="${pList}" var="p">
			<tr>
				<td>${p.pname}
				<td>${p.pprice}
				<td>${p.pdescription}
				
		        <td colspan="2">
				<ul>
					<c:forEach var="file" items="${p.fileInfos}">
					<li>${file.originFile} <a href="#" class="filedown" sfolder="${file.saveFolder}" sfile="${file.saveFile}" ofile="${file.originFile}">[다운로드]</a>
					</c:forEach>
				</ul>
				</td>
				
			</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>

<a href="${root}/function">[기능 페이지로 돌아가기]</a>

</body>
</html>