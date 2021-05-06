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
		int result = template.getMapper(ProductMapper.class).add(product);
		int result2 = template.getMapper(ProductMapper.class).fileRegist(product);
		
		if(result==1 && result2 ==1) {
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public List<ProductDto> list() {
		
		return template.getMapper(ProductMapper.class).list();
	}

}
