package com.ssafy.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.boot.dto.CommentDto;

@Mapper
public interface CommentMapper {
	public List<CommentDto> cmtList(int bnum);
	public int insert(CommentDto dto);
}
