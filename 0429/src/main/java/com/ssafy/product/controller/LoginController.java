package com.ssafy.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.product.dto.MemberDto;
import com.ssafy.product.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService mservice;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(MemberDto member, HttpSession session, Model model) {
		System.out.println("login"+member);
		MemberDto loginInfo = mservice.login(member);
		System.out.println(loginInfo);
//		System.out.println("count는"+mservice.count());
		
		if(loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
			return "product/function";
		}
		else {
			session.invalidate();
			model.addAttribute("loginFailMsg", "틀렸습니다.");
			//아예 로그인 자체를 회원인데 비밀번호를 틀린 경우하고 가입한 적 없는 회원인 경우
			//id가 아예 없는 회원일 경우하고 (보안상으로 안 좋을 듯? 해당 id가 있는 지 없는 지 판단을 내려주는 게 맞자? 이걸 알려줘도 되나?) => 네이버의 경우에는 한 꺼번에 알려주네...
			return "index";
		}
	}
}
