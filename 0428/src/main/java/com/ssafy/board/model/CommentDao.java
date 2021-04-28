package com.ssafy.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

// comment_tb 테이블에 디비 sql 작업하는 클래스
@Repository
public class CommentDao {
	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	// 댓글 작성
	public int insert(CommentDto commentDto) {
		int result = 0;
		try {
			String sql = "INSERT INTO COMMENT_TB(BNUM,CWRITER, CCONTENT) VALUES(?,?,?)";
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, commentDto.getBnum());
			pstmt.setString(2, commentDto.getCwriter());
			pstmt.setString(3, commentDto.getCcontent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	// 게시글 내용 읽기 화면에서 댓글 달린것들 보여줄 때
	public List<CommentDto> selectList(int bnum){
		ArrayList<CommentDto> result = new ArrayList<>();
		try {
			String sql = "SELECT CNUM, BNUM, CWRITER, CCONTENT, CREGDATE FROM COMMENT_TB "
					+" WHERE BNUM=?";
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentDto c = new CommentDto();
				c.setCnum(rs.getInt(1));
				c.setBnum(rs.getInt(2));
				c.setCwriter(rs.getString(3));
				c.setCcontent(rs.getString(4));
				c.setCregdate(rs.getTimestamp(5));
				
				result.add(c);
			}						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
		return result;
	}
	
	// 게시판 목록에서 게시글들에 댓글 몇개씩 달려있는지 버블 달아줄 때
	public int selectCommentCount(int bnum) {
		int result = 0;
		try {
			String sql = "SELECT COUNT(*) FROM COMMENT_TB WHERE BNUM=?";
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
		return result;
	}
}
