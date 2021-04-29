package com.ssafy.product.mapper;

import org.springframework.stereotype.Repository;

import com.ssafy.product.dto.MemberDto;
@Repository
public interface MemberMapper {

	public MemberDto login(MemberDto member);
	public int count();
}
