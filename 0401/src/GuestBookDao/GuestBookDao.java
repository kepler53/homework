package GuestBookDao;

import java.sql.SQLException;
import java.util.List;

import GuestBookDTO.GuestBookDTO;

public interface GuestBookDao {
	
//	글작성
	void registerArticle(GuestBookDTO guestBookDto) throws SQLException;
	
//	글목록
	List<GuestBookDTO> listArticle(String key, String word) throws SQLException;
	

}
