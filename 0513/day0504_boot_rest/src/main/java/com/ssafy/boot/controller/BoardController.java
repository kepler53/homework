package com.ssafy.boot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.boot.dto.BoardDto;
import com.ssafy.boot.model.BoardService;


@RestController
@CrossOrigin("*")
public class BoardController {
	@Autowired
	private BoardService bservice;
	
	@GetMapping("/boardMain") // @ResponseBody 생략. RestController라서!
	public ResponseEntity<Map<String, Object>> main(@RequestParam(value = "page", defaultValue = "1") int page) throws InterruptedException {
		Map<String, Object> result = bservice.makePage(page);

		if (result == null || result.get("bList")==null || ((List)result.get("bList")).size()==0 || result.size() == 0)
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/board") // 글 읽기
	public ResponseEntity<BoardDto> read(int bnum){
		BoardDto result = bservice.read(bnum);
		if(result==null)
			return new ResponseEntity<BoardDto>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<BoardDto>(result, HttpStatus.OK);
	}
	
	@PostMapping("/board") // 글 쓰기
	public ResponseEntity<String> write(@RequestBody BoardDto dto){
		boolean result = bservice.write(dto);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
	}
	
//	@PutMapping("/board") // 글 수정하기
//	public ResponseEntity<String> update(BoardDto dto){
//	}
//	
//	@DeleteMapping("/board") // 글 삭제하기
//	public ResponseEntity<String> delete(int bnum){
//	}
}













