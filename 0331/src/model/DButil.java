package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql connector 없나봄");
			e.printStackTrace();
		}
	}

	public static Connection makeConnection() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hw0331?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","leejh", "dydak5310!");
			return con;
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
