package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	//db 만들기 귀찮다. 그냥 사용하자 예제 데이터
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String ID = "leejh";
	private static final String PASSWORD = "dydak531-!";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//static block으로 설정하면 메모리 위에 올라가서 한 번만 호출되면 계속 메모리 상에 올라가있기 때문에
	//이 때는 렌더링에 영향을 안 받나????????

	public static Connection getConnect() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable ac : closeables) {
			if (ac != null)
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

}