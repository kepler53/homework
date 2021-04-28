package com.ssafy.board.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.MemberDto;
import com.ssafy.board.model.MemberService;


@Controller
public class LoginController {
	
	@Autowired
	private MemberService mservice;
	
	
	@PostMapping("/login")
	public String login(MemberDto member, HttpSession session,Model model) {
		try {
			MemberDto loginInfo = mservice.login(member);
			if(loginInfo!=null) {
				session.setAttribute("loginUser", loginInfo);
				return "redirect:list";
			}else {
				// request에 msg 실겟지 
				model.addAttribute("msg", "id 혹은 패스워드가 틀렸습니다.");
//				return "redirect:/";
				return "index";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		
		//session 설정해야한다. 성공시 session설정 ,  try 구문안에 설정
	}
	
}
