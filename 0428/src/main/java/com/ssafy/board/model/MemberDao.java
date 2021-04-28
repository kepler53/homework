package com.ssafy.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;



@Repository
public class MemberDao {
	
	
	public MemberDto login(MemberDto member) throws SQLException {
		MemberDto loginMember = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.makeConnection();
			String sql = "select bid, bpass, bname from bmember where bid = ? and bpass = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginMember = new MemberDto();
				loginMember.setId(rs.getString(1));
				loginMember.setPass(rs.getString(2));
				loginMember.setName(rs.getString(3));
			}
		}finally {
			DBUtil.close(rs,pstmt,conn);
		}
		return loginMember;
	}
}
