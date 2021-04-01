package GuestBookService;

import java.sql.SQLException;
import java.util.List;

import GuestBookDTO.GuestBookDTO;

public interface GuestBookService {
	
//	글작성
	void registerArticle(GuestBookDTO guestBookDto) throws Exception;
	
//	글목록
	List<GuestBookDTO> listArticle(String key, String word) throws Exception;

}
