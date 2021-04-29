package com.ssafy.product.service;

import java.util.List;

import com.ssafy.product.dto.ProductDto;

public interface ProductService {
	
	public int add(ProductDto product);
	public List<ProductDto> list();

}
