package com.ssafy.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
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
					"jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
					"leejh", "dydak5310!");
			return con;
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
		return null;
	}

	public static void close(AutoCloseable... close) {
		for (AutoCloseable cl : close) {
			if (cl != null) {
				try {
					cl.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
