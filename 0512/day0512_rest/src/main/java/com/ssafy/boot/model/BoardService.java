package com.ssafy.boot.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.boot.dto.BoardDto;
import com.ssafy.boot.dto.CommentDto;
import com.ssafy.boot.mapper.BoardMapper;
import com.ssafy.boot.mapper.CommentMapper;


@Service
public class BoardService {
	@Autowired
	private SqlSession dao; // board 테이블 관련 매퍼(sql)랑 comment 테이블 관련 매퍼(sql) 정보를 다 불러올수 있음.
	private static final int COUNT_PER_PAGE=10;
////////////////////////////////////////////////////////////////////	
	public Map<String, Object> makePage(int page){
		// 총 게시글 갯수 디비에서 조회함.
		int totalCount = dao.getMapper(BoardMapper.class).selectCount();
		
		// 총 페이지수 계산
		int totalPage = totalCount/COUNT_PER_PAGE;
		if(totalCount%COUNT_PER_PAGE>0)
			totalPage++;
		
		// 화면 하단의 시작 페이지
		int startPage = (page-1)/10*10+1;
				
		int endPage = startPage+9;
		if(endPage>totalPage)
			endPage = totalPage;
		
		// 현재 페이지 게시글 조회
		int startRow = (page-1)*COUNT_PER_PAGE; // limit 의 시작행 번호 계산.
		List<BoardDto> bList = dao.getMapper(BoardMapper.class).selectList(startRow, COUNT_PER_PAGE);
		
		Map<String, Object> pageInfo = new HashMap();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("curPage", page);
		pageInfo.put("bList", bList);
	
		return pageInfo;
	}

	public boolean write(BoardDto boardDto) {
		if(dao.getMapper(BoardMapper.class).insert(boardDto)>0)
			return true;
		return false;
	}

	public BoardDto read(int bnum) {
		return dao.getMapper(BoardMapper.class).selectOne(bnum);
	}
///////////////////////////////////////////////////////////////////
	public List<CommentDto> getCmtList(int bnum){
		return dao.getMapper(CommentMapper.class).cmtList(bnum);
	}

	public boolean writeComment(CommentDto cmtDto) {
		if(dao.getMapper(CommentMapper.class).insert(cmtDto)>0)
			return true;
		return false;
	}
}
