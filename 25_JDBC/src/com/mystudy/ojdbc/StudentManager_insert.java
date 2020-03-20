package com.mystudy.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_insert {

	public static void main(String[] args) {
		//0.JDBC 라이브러리 개발환경 설정(빌드경로 등록)
		//1. JDBC 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("[예외 발생] 드라이버 로딩 실패");
			e.printStackTrace();
		}
		
		//2. DB 연결 - Connection 객체 생성(DriverManager)
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//3. statement 문 실행(SQL문)
		Statement stmt = null;
		try {
			//3-1 Connenction 객체로 부터 Statement 객체 생성
			stmt = conn.createStatement();
			
			//3-2. Statement 객체 사용 SQL문 실행
			String sql = "";
			sql += "INSERT INTO STUDENT ";
			sql += "	(ID, NAME, KOR, ENG, MATH, TOT, AVG) ";
			sql += "VALUES ('2019005', '강감찬', 100, 90, 80, 0, 0)";
			System.out.println("sql : " + sql);
			//SELECT 문 : executeQuery()
			//INSERT, UPDATE, DELETE : executeUpdate()
			int result = stmt.executeUpdate(sql);
			
			//4. SQL 실행 결과에 대한 처리
			System.out.println("처리건수 : " + result);
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5. 클로징 처리에 의한 자원반납
		try {
			if(stmt != null)stmt.close();
			if(conn != null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
