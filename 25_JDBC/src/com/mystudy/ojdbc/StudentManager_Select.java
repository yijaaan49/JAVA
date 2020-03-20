package com.mystudy.ojdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Select {

	public static void main(String[] args) {
		//0.JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		//1.JDBC 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> 드라이버 로딩 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("[예외] 드라이버 연결 실패");
			e.printStackTrace();
		}
		
		//2. DB연결 - Connection 객체 생성 <- DriverManager 
		//DriverManager.getConnection(url, user, password);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",//jdbc:oracle:thin:@
				"mystudy", "mystudypw");
			System.out.println(">> db연결 성공");
		} catch(SQLException e) {
			System.out.println("[예외] DB연결 실패");
			e.printStackTrace();
		}
		
		//3. Statement문 실행(SQL문 실행)
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체로 부터 Statement 객체 생성
			stmt = conn.createStatement();
			
			//3.SQL문장 준비하고 실행
			String sql = "";
			sql += "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ";
			sql += " FROM STUDENT ";
			sql += " ORDER BY NAME ";
			rs = stmt.executeQuery(sql);
			//4. SQL 실행 결과에 대한 처리
			//-SELECT : 조회(검색) 데이타 결과 값에 대한 처리
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String str = "";
				str += rs.getString("ID") + "\t";
				str += rs.getString("NAME") + "\t";
				str += rs.getInt("KOR") + "\t";
				str += rs.getInt("ENG") + "\t";
				str += rs.getInt("MATH") + "\t";
				str += rs.getInt("TOT") + "\t";
				str += rs.getInt("AVG") + "\t";
				System.out.println(str);
			}
		} catch (SQLException e) {
			
			System.out.println("[예외] SQL문 실행 실패");
			e.printStackTrace();
		}
		
		
		//5. 클로징 처리에 의한 자원 반납(객체 생성 순서와 역순으로)
		try {
			if(rs != null) {rs.close(); System.out.print("rs종료 성공");}
			if(stmt != null) {stmt.close(); System.out.print("stmt종료 성공");}
			if(conn != null) {conn.close(); System.out.print("conn종료 성공");}
			
		}catch(SQLException e) {
			
		}
	}//end main
}//end class
