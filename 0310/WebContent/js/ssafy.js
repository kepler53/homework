
  $(document).ready(function(){
		
	  	//db가 존재한다면
	  
	  	//궁금한 점 모든 화면에서 login 유지하려면???
		
		
		//2. login submit 부분 파트
		$('#login-btn').click(function() {
			$.ajax({
				url :'js/userlist.jsp',
				type : 'GET',
				dataType : 'xml',
				success: function(response){
					checkLogin(response);
				}	
			});
		});
  
  		function checkLogin(response){
  			
  				//id : login-id,login-pwd
				let id = $('#login-id').val();
				let pwd = $('#login-pwd').val();
				
//				console.log("뭘까?")
				
// 				console.log(id);
// 				console.log(pwd);
  			
  			$(response).find('user').each(function(index,item){
  				var dbId = $(this).find('id').text();
  				var dbPwd = $(this).find('password').text();
  				
  			
  				
  				if(id==dbId && pwd==dbPwd){
  					alert('로그인 성공');
  					// 궁금한 점 break로 each문 못 빠져나가나?
  					//해야할 것 : logout button 만들고 login, Signup의 css invisible로 만들기
  					$('.login').css('display','none');
  					$('.logout').css('display','inline-block');
  					$('.user').text(dbId+'님 환영합니다.');
  					$('.user').css('color','black');
  					return false;
  				}
  				
  			});
  		}
		
  		//3. 로그아웃 버튼 만들기
  		$('#btn-logout').click(function() {
				$('.logout').css('display','none');
				$('.login').css('display','inline-block');
  		})
	
  		//4. 글 작성을 누르면 db에 저장되어야함
  		$('#btn-write').click(function(){
  			//사용자의 이름을 가져오고 작성 제목,작성 내용을 넘긴다. 이후에 DB에 저장
  		});
  		
  		//5. 초기화버튼을 누르면 작성 내용 삭제
  		$('#btn-reset').click(function(){
  				$('.title').val('');
  		//  	$('#text-content').val(''); => 이건  왜 안 되는걸까?
  		})
  		
  		//6. 목록 버튼을 누르면 ssafyWrite로 넘어가기
  		$('#btn-list').click(function() {
			
  			$(location).attr('href','http://localhost:8080/0310/ssafyWrite.html');
		});
  		
  		
  		
  		
  		
	});