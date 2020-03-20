package com.mystudy.jdbc_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Close {
	public static void closeConnStmtRs(Connection conn,
			PreparedStatement pstmt) {
		//3 Statement 문 실행(SQL문 실행)
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnStmtRs(Connection conn,
			PreparedStatement pstmt, ResultSet rs) {
		//3 Statement 문 실행(SQL문 실행)
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
