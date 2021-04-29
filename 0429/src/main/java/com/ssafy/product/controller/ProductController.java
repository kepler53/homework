package com.ssafy.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.dto.ProductDto;
import com.ssafy.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/add")
	public String add() {
		return "product/add";
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		List<ProductDto> pList = pservice.list();
		
		
		for (ProductDto productDto : pList) {
			System.out.println(productDto);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("pList", pList);
		mav.setViewName("product/list");
		return mav;
	}
	
	@PostMapping("/add")
	public String add(ProductDto product,Model model) {
		
		System.out.println(product);
		int result = pservice.add(product);
		if(result>0) {
			model.addAttribute("addSuccessMsg", "상품추가에 성공하였습니다.");
			return "product/function";
		}else {
			model.addAttribute("addfailMsg","상품추가에 실패하였습니다.");
			return "product/add";
		}
		
		//오늘은 ajax 안쓰고 내일 추가하기, 그냥 추가 실패했다고 하고 
		//설명의 글자 수 세서 500개 이상이면 바로 처리해버리기, sql exception남 바로 처리해주기,service에서
	}
	
	@GetMapping("/function")
	public String back() {
		return "product/function";
	}
	

}
