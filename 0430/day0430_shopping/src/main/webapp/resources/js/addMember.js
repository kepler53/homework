/**
 * 
 */

 //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
    
    let pwd_flag = false;
	$('#pwd').keyup(function() {
	// 	console.log(this)
		if($(this).val()=='' || $(this).val().length==0){
			$('#pw-msg').text('패스워드를 입력하세요');
			$('#pw-msg').css('color', 'red');
		}else if($(this).val().length<8){
			$('#pw-msg').text('안전도 낮음');
			$('#pw-msg').css('color', 'red');
		}else{
			$('#pw-msg').text('안전도 높음');
			$('#pw-msg').css('color', 'green');
			pwd_flag = true;
		}
	})
	
	let pwd_check_flag = false;
	$('#pwd-check').keyup(function() {
		if($(this).val()==$('#pwd').val()){
			$('#pw-confirm-msg').text('비밀번호 일치');
			$('#pw-confirm-msg').css('color', 'green');
			pwd_check_flag = true;
		}else{
			$('#pw-confirm-msg').text('비밀번호 불일치');
			$('#pw-confirm-msg').css('color', 'red');
		}
	})
	
	
	// $('#id-check').click(function(){
		
	// 	console.log($('#id').val());
	// 	$.ajax({
	// 		url : '${root}/ajax?id='+$('#id').val(),
	// 		method : 'get', 
	// 		contentType : "application/json; charset:UTF-8",
	// 		dataType : 'text',
			
	// 		success : function(data){
				
	// 			if(data=='사용할 수 있습니다.'){
	// // 				checkflag = true;
	// 				alert('아이디는 사용가능합니다');
	// // 				$('#id-check-msg').text('사용가능').css('color','green')
	// // 				$('#id').val
	// 			}else{
	// 				alert('다른 아이디를 사용해주세요');
	// // 				$('#id-check-msg').text('사용불가').css('color','red')
	// 			}
	// 		}
	// 	})
	// })
	let login_flag = false;
	$('#id').blur(function(){
		
// 		console.log($('#id').val());
		var value = $('#id').val();
		$.ajax({
			url : 'ajax?id='+$('#id').val(),
			method : 'get', 
			contentType : "application/json; charset:UTF-8",
			dataType : 'text',
			
			success : function(data){
				//이 부분 더 추가하기 조건 : 정규표현식
				if(data=='사용할 수 있습니다.'){
					if(value.length>7){
						$('#id-check-msg').text('사용가능').css('color','green')
						login_flag = true;
					}else if(value.length<=6){
						$('#id-check-msg').text('아이디는 8글자 이상입니다.').css('color','red')	
					}
				}else{
	// 				alert('다른 아이디를 사용해주세요');
					$('#id-check-msg').text('사용불가').css('color','red')
				}
			}
		})
	})
	
	$('#regist-btn').click(function(){
		if(login_flag&&pwd_flag&&pwd_check_flag){
			$('#regist-form').submit();
		}else{
			alert("조건을 만족하지 못하였습니다.");
		}
	})
	
	//context path 구하기
// 	function getContextPath() {
// 		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
// 		return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
// 	};

// 	$(document).ready(function(){
// 		$("#viewText").html( getContextPath() );
// 	});