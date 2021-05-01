package com.ssafy.shopping.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.shopping.dto.MemberDto;
import com.ssafy.shopping.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public int insert(MemberDto member) {
		return template.getMapper(MemberMapper.class).insert(member);
	}

	@Override
	public boolean check(String id) {
		int result =template.getMapper(MemberMapper.class).check(id);
		if(result==1) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public MemberDto login(MemberDto member) {
		
		return template.getMapper(MemberMapper.class).login(member);
	}

}
