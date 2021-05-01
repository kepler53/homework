package com.ssafy.shopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.shopping.dto.MemberDto;
import com.ssafy.shopping.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/addMember")
	public String addMember() {
		return "member/add";
	}
	
	@PostMapping("/addMember")
	public String addMember(MemberDto member,@RequestParam(value = "spec-address")String address
			, Model model) {
		
		member.setAddress(member.getAddress()+" "+address);
		System.out.println(member);
		int result =mservice.insert(member);
		if(result ==1) {
			model.addAttribute("insertMsg", "회원가입에 성공했습니다.");
		}else {
			model.addAttribute("insertMsg", "회원가입에 실패하였습니다.");
		}
		
		return "index";
	}
	
//	@PostMapping("/login")
	
	
	@GetMapping(value = "/ajax",produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String checkMember(@RequestParam(value = "id")String id) {
//		System.out.println(id);
		if(mservice.check(id)) {
			return "사용할 수 있습니다.";
		}else {
			return "사용할 수 없습니다.";
		}
	}
	
	@PostMapping("/login")
	public String login(MemberDto member) {
		
		MemberDto loginInfo = mservice.login(member);
		System.out.println(loginInfo);
		
		
		return "member/list";
		
		
	}
	
	
	
	
}
