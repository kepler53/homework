package com.ssafy.product.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dto.MemberDto;
import com.ssafy.product.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public MemberDto login(MemberDto member) {
		System.out.println(member);
		return template.getMapper(MemberMapper.class).login(member);
	}

	@Override
	public int count() {
		
		return template.getMapper(MemberMapper.class).count();
	}

	

}
