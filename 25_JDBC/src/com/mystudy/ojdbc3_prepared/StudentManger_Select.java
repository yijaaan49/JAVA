package com.mystudy.ojdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManger_Select {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
			String sql = "";
			sql += "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ";
			sql += "  FROM STUDENT ";
			sql += "WHERE ID = ? "; // ? :  바인드 변수 위치 표시
			//preparedStatement문 실행
			
			pstmt = conn.prepareStatement(sql);
			//3-2 ?(바인드변수) 위치에 값 대입
			String id = "2019001";
			pstmt.setString(1, id);
			
			//3-3 Statement (preparedStatement) 실행
			rs = pstmt.executeQuery();
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
