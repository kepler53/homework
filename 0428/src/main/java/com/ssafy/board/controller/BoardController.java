package com.ssafy.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.BoardService;
import com.ssafy.board.model.CommentDto;

@Controller
public class BoardController {

	@Autowired
	private BoardService bservice;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
//	@GetMapping("/list/{page}")
//	public ModelAndView list(@PathVariable("page") int page) {
//		ModelAndView mav = new ModelAndView("board_list");
//		mav.addObject("pageInfo", bservice.makePage(page));
//		return mav;
//	}
//	
	@GetMapping("/list") // parameter가 url에 나타나는 구식 버전 
	public ModelAndView list(@RequestParam(defaultValue = "1") int page) {
		ModelAndView mav = new ModelAndView("board_list");
		mav.addObject("pageInfo", bservice.makePage(page));
		return mav;
	}
	
	@GetMapping("/read/{bnum}") // parameter 이름이 url에 나타나지 않고 값만 들어있는 신식 버전
	public ModelAndView read(@PathVariable("bnum") int bn) {
		ModelAndView mav = new ModelAndView("board_read");
		mav.addObject("boardDto", bservice.read(bn));
		return mav;
	}
	
	@GetMapping("/write")
	public String write(HttpServletRequest request, HttpSession session) {
//		Member loginInfo = session.getAttribute("loginInfo");
//		if(loginInfo!=null) { // 로그인 되어있으면
//			return "board_write"; // 글 여기다가 쓰렴 ^^
//		}else {
//			request.setAttribute("msg", "로그인이 필요합니다.");
//			return "index";
//		}
		return "board_write";	
	}
	
//	@PostMapping("/write")
//	public String write(String btitle, String bcontent, String bwriter) {
//		
//	}
	@PostMapping("/write")
	public String write(BoardDto board) {
		if(bservice.write(board))
			return "write_success";
		else
			return "write_fail";
	}
	
	@GetMapping(value="/ajax", produces = "application/json;charset=utf8") // 댓글 목록좀 주세염 이라는 요청(댓글에 있는 한글 처리땜시 produces추가함.)
	@ResponseBody
	public String ajax(int bnum){
		System.out.println("ajax:"+bnum);
		Gson gs = new Gson();
		return gs.toJson(bservice.getCmtList(bnum));
	}
	
	@PostMapping(value="/ajax") // 댓글 쓸래염 이라는 요청
	@ResponseBody
	public String ajax(@RequestBody CommentDto cmtDto) { // javascript 에서 json 데이터를 보냈을 때 back은 @RequestBody로 받아야 함.
		if(bservice.writeComment(cmtDto))
			return "success"; // success.jsp 아니니까! html 만드는거 아니니까! 그냥 이 데이터 바로 response
		else
			return "fail";
	}
}








