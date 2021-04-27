package com.ssafy.product.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.repository.ProductDao;
import com.ssafy.productdto.ProductDto;

@Service
public class ProductService {

	@Autowired
	private ProductDao pdao;
	
	public void add(ProductDto product) throws SQLException {
		pdao.add(product);
	}
	
	public List<ProductDto> getList() throws SQLException{
		return pdao.getList();
	}
	
}
