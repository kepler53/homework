package GuestBookDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import DBUtil.DBUtil;
import GuestBookDTO.GuestBookDTO;

public class GuestBookDaoImpl implements GuestBookDao {

	private static GuestBookDao guestBookDao;
	
	private GuestBookDaoImpl() {}
	
	public static GuestBookDao getGuestBookDao() {
		if(guestBookDao == null)
			guestBookDao = new GuestBookDaoImpl();
		return guestBookDao;
	}
	
	@Override
	public void registerArticle(GuestBookDTO guestBookDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnect();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("insert into guestbook (userid, subject, content, regtime) \n");
			insertMember.append("values (?, ?, ?, now())");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, guestBookDto.getUserId());
			pstmt.setString(2, guestBookDto.getSubject());
			pstmt.setString(3, guestBookDto.getContent());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<GuestBookDTO> listArticle(String key, String word) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
