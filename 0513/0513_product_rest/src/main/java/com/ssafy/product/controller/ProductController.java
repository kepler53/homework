package com.ssafy.product.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.dto.ProductDto;
import com.ssafy.product.service.ProductService;


@CrossOrigin("*")
@RestController
public class ProductController {

	
	@Autowired
	private ProductService pservice;
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<ProductDto>> list(){
		
		List<ProductDto> result;
		try {
			result = pservice.list();
			
			if(result==null || result.size()==0) {
				return new ResponseEntity<List<ProductDto>>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<List<ProductDto>>(result,HttpStatus.OK);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return new ResponseEntity<List<ProductDto>>(HttpStatus.RESET_CONTENT);
		}
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody ProductDto product ){
		
		int result;
		try {
			result = pservice.add(product);
			if(result>0) {
				return new ResponseEntity<String>("success",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("failure",HttpStatus.NOT_FOUND);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("들어왔니");
			return new ResponseEntity<String>("failure",HttpStatus.RESET_CONTENT);
		}
		
	}
	
	
}
