package com.mystudy.ojdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentManager_insert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
			String sql = "";
			sql += "INSERT INTO STUDENT "; // ? :  바인드 변수 위치 표시
			sql += "  (ID, NAME, KOR, ENG, MATH) ";
			sql += "VALUES (?, ?, ?, ?, ?) ";
			//preparedStatement문 실행
			
			pstmt = conn.prepareStatement(sql);
			//3-2 ?(바인드변수) 위치에 값 대입
			String id = "2019011";
			String name = "홍길동";
			int kor = 90;
			int eng = 80;
			int math = 70;
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, math);
			
			//3-3 Statement (preparedStatement) 실행
			int result = pstmt.executeUpdate();
			//4. sql 실행 결과에 대한 처리
			// -select : 조회 검색 데이타 결과 값에 대한 처리
			
			System.out.println(">> 처리건수 : " + result);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
