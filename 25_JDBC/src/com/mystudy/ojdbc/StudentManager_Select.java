package com.mystudy.ojdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Select {

	public static void main(String[] args) {
		//0.JDBC ���̺귯�� ����ȯ�� ����(�����ο� ���)
		//1.JDBC ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> ����̹� �ε� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println("[����] ����̹� ���� ����");
			e.printStackTrace();
		}
		
		//2. DB���� - Connection ��ü ���� <- DriverManager 
		//DriverManager.getConnection(url, user, password);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",//jdbc:oracle:thin:@
				"mystudy", "mystudypw");
			System.out.println(">> db���� ����");
		} catch(SQLException e) {
			System.out.println("[����] DB���� ����");
			e.printStackTrace();
		}
		
		//3. Statement�� ����(SQL�� ����)
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//Connection ��ü�� ���� Statement ��ü ����
			stmt = conn.createStatement();
			
			//3.SQL���� �غ��ϰ� ����
			String sql = "";
			sql += "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ";
			sql += " FROM STUDENT ";
			sql += " ORDER BY NAME ";
			rs = stmt.executeQuery(sql);
			//4. SQL ���� ����� ���� ó��
			//-SELECT : ��ȸ(�˻�) ����Ÿ ��� ���� ���� ó��
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
			
			System.out.println("[����] SQL�� ���� ����");
			e.printStackTrace();
		}
		
		
		//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�(��ü ���� ������ ��������)
		try {
			if(rs != null) {rs.close(); System.out.print("rs���� ����");}
			if(stmt != null) {stmt.close(); System.out.print("stmt���� ����");}
			if(conn != null) {conn.close(); System.out.print("conn���� ����");}
			
		}catch(SQLException e) {
			
		}
	}//end main
}//end class
