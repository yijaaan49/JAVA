package com.mystudy.ojdbc2_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManger_insert {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
			
			stmt = conn.createStatement();
			String sql = "";
			String id = "2019006";
			String name = "홍경래";
			int kor = 100;
			int eng = 90;
			int math = 80;
			sql += "INSERT INTO STUDENT ";
			sql += "	(ID, NAME, KOR, ENG, MATH) ";
			sql += " VALUES ('"+ id +"', '"+ name +"', "+ kor 
					+", "+ eng +", "+ math +") ";
			System.out.println(sql);
			int result = stmt.executeUpdate(sql);
			System.out.println("처리건수 : " + result);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
