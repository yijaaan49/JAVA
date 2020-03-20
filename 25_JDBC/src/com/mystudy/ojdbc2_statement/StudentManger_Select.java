package com.mystudy.ojdbc2_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManger_Select {

	public static void main(String[] args) {
		//0. JDBC 라이브러리 개발환경 설정

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//1. JDBC 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
			//3. statement 문 실행(SQL문 실행)
			//3-1 Connection 객체로 부터 Statement 객체생성
			stmt = conn.createStatement();
			
			//3-2 Statement 객체를 이용해서 SQL문 실행
			String sql = "";
			String id = "2019006";
			sql += "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ";
			sql += " FROM STUDENT ";
			sql += " WHERE ID = '" + id + "'";
			
			System.out.println("sql : " + sql);
			
			rs = stmt.executeQuery(sql);
			//4. sql 실행 결과에 대한 처리
			// -select : 조회 검색 데이타 결과 값에 대한 처리
			while (rs.next()) {
				String str = "";
				str += rs.getString(1) + "\t";
				str += rs.getString(2) + "\t";
				str += rs.getInt(3) + "\t";
				str += rs.getInt(4) + "\t";
				str += rs.getInt(5) + "\t";
				str += rs.getInt(6) + "\t";
				str += rs.getDouble(7);
				System.out.println(str);
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
