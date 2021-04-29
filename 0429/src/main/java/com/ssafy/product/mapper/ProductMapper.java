package com.ssafy.product.mapper;

import java.util.List;

import com.ssafy.product.dto.ProductDto;

public interface ProductMapper {
	
	public int add(ProductDto product);
	public List<ProductDto> list();

}
