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
			sql += "INSERT INTO STUDENT "; // ? :  ���ε� ���� ��ġ ǥ��
			sql += "  (ID, NAME, KOR, ENG, MATH) ";
			sql += "VALUES (?, ?, ?, ?, ?) ";
			//preparedStatement�� ����
			
			pstmt = conn.prepareStatement(sql);
			//3-2 ?(���ε庯��) ��ġ�� �� ����
			String id = "2019011";
			String name = "ȫ�浿";
			int kor = 90;
			int eng = 80;
			int math = 70;
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, math);
			
			//3-3 Statement (preparedStatement) ����
			int result = pstmt.executeUpdate();
			//4. sql ���� ����� ���� ó��
			// -select : ��ȸ �˻� ����Ÿ ��� ���� ���� ó��
			
			System.out.println(">> ó���Ǽ� : " + result);
			
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
