package com.ssafy.product.service;

import org.springframework.stereotype.Service;

import com.ssafy.product.dto.MemberDto;

@Service
public interface MemberService {
	
	public MemberDto login(MemberDto member);
	public int count();

}
