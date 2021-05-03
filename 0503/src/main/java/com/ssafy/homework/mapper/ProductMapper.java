package com.ssafy.homework.mapper;

import java.util.List;

import com.ssafy.homework.dto.ProductDto;

public interface ProductMapper {
	
	public int add(ProductDto product);
	public List<ProductDto> list();

}
