package com.ssafy.homework.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.homework.dto.ProductDto;

public interface ProductService {
	
	public int add(ProductDto product) throws SQLException;
	
	public List<ProductDto> list() throws SQLException;

}
