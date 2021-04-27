package com.ssafy.product.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.service.ProductService;
import com.ssafy.productdto.ProductDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private ProductService pservice;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "home";
	}
	
	
	
	//상품추가
	@GetMapping("/add")
	public String productAdd() {
		return "product/add";
	}
	
	@PostMapping("/add")
	public String productAdd(ProductDto product) throws Exception {
		pservice.add(product);
		return "home";
	}
	
	@GetMapping("/productList")
	public ModelAndView productList() throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		List<ProductDto> pList = pservice.getList();
		for (ProductDto productDto : pList) {
			System.out.println("---------");
			System.out.println(productDto);
		}
		mav.addObject("pList", pList);
		mav.setViewName("product/list");
		return mav;
	}
}
