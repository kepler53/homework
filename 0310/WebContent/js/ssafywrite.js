
$(document).ready(function(){
	
	
	// 1. 글쓰기 태그를 눌렀을 때
	//	
	//	  $('#btn-write').click(function() {	
	//	 		$(this).attr('href','http://localhost:8080/0310/ssafyMain.html');
	//		});
	// 궁금한 점 왜 이렇게 하면 안되는 지 모르겠음, a태그에 href주는 것하고 이것의 차이가 뭔지?????
	
	// 2. 검색 결과 조건에 따라서 결과를 table에  뿌려주기
	// 
	
		$('#search-btn').click(function() {
			
			$.ajax({
				url : 'js/uploadlist.json',
				type : 'GET',
				dataType: "json",
				success: function(data){
					searchByOption(data);
				}	
			});
		});
		
		//Network 상에 연결이 되었는 데 왜 콘솔이 안찍히는지 모르겠음
		// json 파일에 , 쉼표 안 붙여서 찾느라 1시간반을 보냈습니다.
		// 검색 누를 때 table에 뿌려진 거 다 없애야 하는지???
		function searchByOption(data){
			
			
			let option = $("#sel option:selected").text();
			let optionType;
			//select 태그의 옵션 값 글 번호, 제목, 작성자, 작성일
			let input = $('#search-input').val();
			
			if(option=='글번호'){
				optionType = 'number';
			}else if(option=='제목'){
				optionType = 'title';
			}else if(option=='작성자'){
				optionType = 'writer';
			}else if(option=='작성일'){
				optionType = 'date';
			}
//			console.log(optionType);
//			console.log(input);
			
			$.each(data,function(index,item){
				
				//이부분에서 optionType으로 질의를 날린 후에 검색...그리고 table에 추가
				
			})
			
			$('#upload-list').empty();
		
		}
	
	// 3. table의 하나를 클릭했을 때 ssafyread.html로 넘어가기 넘어갈 때 값들 가지고 넘어간다.
	
	// 4. pagination을 클릭할 때 계속 변경이 일어나야 한다. => 이 때 index도 같이 넘겨야하는 지???
	
	// 5. 그냥 화면에 uploadlist Table에 뿌리기
	
})