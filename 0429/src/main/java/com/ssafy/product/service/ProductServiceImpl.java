package com.ssafy.product.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dto.ProductDto;
import com.ssafy.product.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public int add(ProductDto product) {
		return template.getMapper(ProductMapper.class).add(product);
	}

	@Override
	public List<ProductDto> list() {
		// TODO Auto-generated method stub
		return template.getMapper(ProductMapper.class).list();
	}

}
