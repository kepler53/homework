package com.ssafy.homework.service;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homework.dto.ProductDto;
import com.ssafy.homework.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public int add(ProductDto product) throws SQLException {
		System.out.println(product);
		return template.getMapper(ProductMapper.class).add(product);
	}

	@Override
	public List<ProductDto> list() throws SQLException {
		
		return template.getMapper(ProductMapper.class).list();
	}

}
