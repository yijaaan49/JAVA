package com.mystudy.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_insert {

	public static void main(String[] args) {
		//0.JDBC ���̺귯�� ����ȯ�� ����(������ ���)
		//1. JDBC ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("[���� �߻�] ����̹� �ε� ����");
			e.printStackTrace();
		}
		
		//2. DB ���� - Connection ��ü ����(DriverManager)
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//3. statement �� ����(SQL��)
		Statement stmt = null;
		try {
			//3-1 Connenction ��ü�� ���� Statement ��ü ����
			stmt = conn.createStatement();
			
			//3-2. Statement ��ü ��� SQL�� ����
			String sql = "";
			sql += "INSERT INTO STUDENT ";
			sql += "	(ID, NAME, KOR, ENG, MATH, TOT, AVG) ";
			sql += "VALUES ('2019005', '������', 100, 90, 80, 0, 0)";
			System.out.println("sql : " + sql);
			//SELECT �� : executeQuery()
			//INSERT, UPDATE, DELETE : executeUpdate()
			int result = stmt.executeUpdate(sql);
			
			//4. SQL ���� ����� ���� ó��
			System.out.println("ó���Ǽ� : " + result);
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5. Ŭ��¡ ó���� ���� �ڿ��ݳ�
		try {
			if(stmt != null)stmt.close();
			if(conn != null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
