package com.mystudy.ojdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentManager_Update {
	public static void main(String[] args) {
		// 실습 2019001 데이터 수정
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
			String sql = "UPDATE STUDENT SET NAME = ? , KOR = ? , ENG = ? , MATH = ?"
					+ " WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "홍길동");
			pstmt.setInt(2, 100);
			pstmt.setInt(3, 90);
			pstmt.setInt(4, 80);
			pstmt.setString(5, "2019001");
			int tmep = pstmt.executeUpdate();
			System.out.println("수정 " + tmep);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
