package GuestBookService;

import java.sql.SQLException;
import java.util.List;

import GuestBookDTO.GuestBookDTO;
import GuestBookDao.GuestBookDaoImpl;

public class GuestBookServiceImpl implements GuestBookService {

	private static GuestBookService guestBookService;
	
	private GuestBookServiceImpl() {}
	
	public static GuestBookService getGuestBookService() {
		if(guestBookService == null)
			guestBookService = new GuestBookServiceImpl();
		return guestBookService;
	}
	
	@Override
	public void registerArticle(GuestBookDTO guestBookDto) throws Exception {
		GuestBookDaoImpl.getGuestBookDao().registerArticle(guestBookDto);
	}

	@Override
	public List<GuestBookDTO> listArticle(String key, String word) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
