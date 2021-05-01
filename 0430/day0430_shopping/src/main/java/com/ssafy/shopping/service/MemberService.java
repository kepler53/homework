package com.ssafy.shopping.service;

import com.ssafy.shopping.dto.MemberDto;

public interface MemberService {
	
	
	public int insert(MemberDto member);

	public boolean check(String id);

	public MemberDto login(MemberDto member);
}
