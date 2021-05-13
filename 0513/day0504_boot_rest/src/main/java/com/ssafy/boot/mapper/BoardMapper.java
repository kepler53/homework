package com.ssafy.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.boot.dto.BoardDto;

@Mapper // 이것도 자동 스캔당함 ㅋㅋ
public interface BoardMapper {
	public int insert(BoardDto dto);
	public BoardDto selectOne(int bnum);
	public List<BoardDto> selectList(@Param("startRow")int startRow, @Param("count")int count);
	public int selectCount();
}
