<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="root" value="${pageContext.request.contextPath}" />      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
	.address-input{
		width: 400px;
		height: 20px;
		margin-bottom: 15px;
	}
	.regist-input{
		margin-bottom: 15px;
	}

</style>
</head>
<body>

<!-- 테이블에 담아서 깔끔하게 보여주기 -->

	<form action="${pageContext.request.contextPath}/addMember" method="post" id="regist-form">
		<table>
		<tr>
			<td>아이디  :</td> 
			<td><input type="text" class="regist-input" name="id" id="id" maxlength="16"></td> 
		<!-- 	<button id="id-check"> 중복체크</button> -->
			<td><span id="id-check-msg"></span><br></td>
			<br>
		</tr>
	<!-- 	ajax로 아이디 사용가능한지 check -->
		<tr>
			<td>비밀번호 : 
			<td><input type="password" class="regist-input" name = "pwd" id="pwd" maxlength="20">
			<td><span id="pw-msg">패스워드를 입력하세요.</span><br>
		</tr>
		<tr>
			<td>비밀번호 확인 : 
			<td><input type="password" class="regist-input" name="pwd-check" id="pwd-check" maxlength="20">
			<td><span id="pw-confirm-msg">패스워드를 입력하세요.</span><br>
		</tr>
		<tr>
			<td>이름  : 
			<td><input type="text" class="regist-input" name="name"><br>
		</tr>
	<!-- front단에서 비밀번호 유효성 체크	 -->
		
	

		<tr>
			<td>주소 :
			<td><input type="text"  id="sample4_postcode" placeholder="우편번호" class="regist-input">
			<td><input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="regist-input"><br>
		</tr>
		<tr>
			<td>도로명 주소 :
			<td><input type="text" name="address" id="sample4_roadAddress" placeholder="도로명주소" class="address-input regist-input"><br>
		</tr>
		<tr>
			<td>지번 주소 : 
			<td><input type="text" id="sample4_jibunAddress" placeholder="지번주소" class="address-input regist-input"><br>
			<td><span id="guide" style="color:#999;display:none"></span>
		</tr>
		<tr>
			<td>상세 주소 : 
			<td><input type="text" name="spec-address" id="sample4_detailAddress" placeholder="상세주소를 입력하세요" class="address-input regist-input"><br>
		</tr>
		<tr>
			<td>참고 항목 : 
			<td><input type="text" id="sample4_extraAddress" placeholder="참고항목" class="address-input regist-input">
		</tr>
		</table>
		<input type="button" value="가입하기" id="regist-btn">
<!-- 		<div>ContextPath : <span id="viewText"></span></div> -->
	</form>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${root}/resources/js/addMember.js"></script>

<!-- 이 경로를 못 바꾸나 -->

<script>
//     //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
//     function sample4_execDaumPostcode() {
//         new daum.Postcode({
//             oncomplete: function(data) {
//                 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

//                 // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
//                 // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
//                 var roadAddr = data.roadAddress; // 도로명 주소 변수
//                 var extraRoadAddr = ''; // 참고 항목 변수

//                 // 법정동명이 있을 경우 추가한다. (법정리는 제외)
//                 // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
//                 if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
//                     extraRoadAddr += data.bname;
//                 }
//                 // 건물명이 있고, 공동주택일 경우 추가한다.
//                 if(data.buildingName !== '' && data.apartment === 'Y'){
//                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
//                 }
//                 // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
//                 if(extraRoadAddr !== ''){
//                     extraRoadAddr = ' (' + extraRoadAddr + ')';
//                 }

//                 // 우편번호와 주소 정보를 해당 필드에 넣는다.
//                 document.getElementById('sample4_postcode').value = data.zonecode;
//                 document.getElementById("sample4_roadAddress").value = roadAddr;
//                 document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
//                 // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
//                 if(roadAddr !== ''){
//                     document.getElementById("sample4_extraAddress").value = extraRoadAddr;
//                 } else {
//                     document.getElementById("sample4_extraAddress").value = '';
//                 }

//                 var guideTextBox = document.getElementById("guide");
//                 // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
//                 if(data.autoRoadAddress) {
//                     var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
//                     guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
//                     guideTextBox.style.display = 'block';

//                 } else if(data.autoJibunAddress) {
//                     var expJibunAddr = data.autoJibunAddress;
//                     guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
//                     guideTextBox.style.display = 'block';
//                 } else {
//                     guideTextBox.innerHTML = '';
//                     guideTextBox.style.display = 'none';
//                 }
//             }
//         }).open();
//     }
    

// 	$('#pwd').keyup(function() {
// 	// 	console.log(this)
// 		if($(this).val()=='' || $(this).val().length==0){
// 			$('#pw-msg').text('패스워드를 입력하세요');
// 			$('#pw-msg').css('color', 'red');
// 		}else if($(this).val().length<8){
// 			$('#pw-msg').text('안전도 낮음');
// 			$('#pw-msg').css('color', 'red');
// 		}else{
// 			$('#pw-msg').text('안전도 높음');
// 			$('#pw-msg').css('color', 'green');
// 		}
// 	})
	
	
// 	$('#pwd-check').keyup(function() {
// 		if($(this).val()==$('#pwd').val()){
// 			$('#pw-confirm-msg').text('비밀번호 일치');
// 			$('#pw-confirm-msg').css('color', 'green');
// 		}else{
// 			$('#pw-confirm-msg').text('비밀번호 불일치');
// 			$('#pw-confirm-msg').css('color', 'red');
// 		}
// 	})
	
	
// 	// $('#id-check').click(function(){
		
// 	// 	console.log($('#id').val());
// 	// 	$.ajax({
// 	// 		url : '${root}/ajax?id='+$('#id').val(),
// 	// 		method : 'get', 
// 	// 		contentType : "application/json; charset:UTF-8",
// 	// 		dataType : 'text',
			
// 	// 		success : function(data){
				
// 	// 			if(data=='사용할 수 있습니다.'){
// 	// // 				checkflag = true;
// 	// 				alert('아이디는 사용가능합니다');
// 	// // 				$('#id-check-msg').text('사용가능').css('color','green')
// 	// // 				$('#id').val
// 	// 			}else{
// 	// 				alert('다른 아이디를 사용해주세요');
// 	// // 				$('#id-check-msg').text('사용불가').css('color','red')
// 	// 			}
// 	// 		}
// 	// 	})
// 	// })
	
// 	$('#id').blur(function(){
		
// // 		console.log($('#id').val());
// 		var value = $('#id').val();
// 		$.ajax({
// 			url : '${root}/ajax?id='+$('#id').val(),
// 			method : 'get', 
// 			contentType : "application/json; charset:UTF-8",
// 			dataType : 'text',
			
// 			success : function(data){
				
// 				if(data=='사용할 수 있습니다.'){
// 					if(value.length>7){
// 						$('#id-check-msg').text('사용가능').css('color','green')
// 					}else if(value.length<=6){
// 						$('#id-check-msg').text('아이디는 8글자 이상입니다.').css('color','red')	
// 					}
// 				}else{
// 	// 				alert('다른 아이디를 사용해주세요');
// 					$('#id-check-msg').text('사용불가').css('color','red')
// 				}
// 			}
// 		})
// 	})
	
// 	//context path 구하기
// // 	function getContextPath() {
// // 		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
// // 		return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
// // 	};

// // 	$(document).ready(function(){
// // 		$("#viewText").html( getContextPath() );
// // 	});

</script>




</body>
</html>