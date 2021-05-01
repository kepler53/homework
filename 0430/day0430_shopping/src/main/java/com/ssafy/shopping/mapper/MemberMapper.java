package com.ssafy.shopping.mapper;

import com.ssafy.shopping.dto.MemberDto;

public interface MemberMapper {
	
	public int insert(MemberDto member);
	
	public int check(String id);

	public MemberDto login(MemberDto member);
	
}
