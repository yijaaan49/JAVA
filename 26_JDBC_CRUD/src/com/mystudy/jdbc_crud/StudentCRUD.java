package com.mystudy.jdbc_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentCRUD {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	StudentCRUD() {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(">> ����̹� �ε�����");
			e.printStackTrace();
		}
		
	}
	//Student ���̺��� �ִ� 1���� ������ ��ȸ�ؼ� ȭ�� ǥ��
	//ID���� �����ϸ� ������ �����ͼ� ȭ�鿡 ǥ��
	public boolean dispData(String id) {
		boolean cut = true;
		try {
			
			//������ ���̽� �����۾�
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
						"mystudy", "mystudypw");
			//3 Statement �� ����(SQL�� ����)
			String sql = "";
			sql += "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG";
			sql += " FROM STUDENT ";
			sql += " WHERE ID = ? ";
			//3-1 PreparedStatment ��ü ����
			pstmt = conn.prepareStatement(sql);
			
			//3-2 ? (���ε� ����)�� ���� ����
			pstmt.setString(1, id);
			
			//3-3 SQL����
			rs = pstmt.executeQuery();
			
			//4.SQL �������� ���� ó��
			//SELECT : ��ȸ
			if(rs.next()) {
				String str = "";
				str += rs.getString(1) + "\t";
				str += rs.getString(2) + "\t";
				str += rs.getInt(3) + "\t";
				str += rs.getInt(4) + "\t";
				str += rs.getInt(5) + "\t";
				str += rs.getInt(6) + "\t";
				str += rs.getDouble(7);
				System.out.println(str);
			}else {
				System.out.println(id + " - ������ ����");
				cut = false;
			}
			
		} catch (SQLException e) {
			System.out.println(">>������ ���̽� ���ӽ���");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cut;
	}
	public StudentVO selectId(String id) {
		StudentVO stu = null;
		//(����) DB�����ϰ� SQL���� �����ؼ� ������� ������ STU������ �����Ѵ�.
		//������ ���̽� �����۾�
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
						"mystudy", "mystudypw");
			//3 Statement �� ����(SQL�� ����)
			String sql = "";
			sql += "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG";
			sql += " FROM STUDENT ";
			sql += " WHERE ID = ? ";
			//3-1 PreparedStatment ��ü ����
			pstmt = conn.prepareStatement(sql);
			
			//3-2 ? (���ε� ����)�� ���� ����
			pstmt.setString(1, id);
			
			//3-3 SQL����
			rs = pstmt.executeQuery();
			//4. SQL �������� ���� ó��
			if(rs.next()) {//�����Ͱ� ������
				//StudentVO Ÿ���� stu ������ ��ȸ ������ ����
				stu = new StudentVO(id, rs.getString("NAME")
						, rs.getInt("KOR"), rs.getInt("ENG"), rs.getInt("MATH")
						, rs.getInt("TOT"), rs.getDouble("AVG"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return stu;
	}
	
	private void closeConnStmtRs(Connection conn,
			PreparedStatement pstmt,
			ResultSet rs) {
		//3 Statement �� ����(SQL�� ����)
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//��ü ������ ��ȸ�ؼ� ArrayList�� ��Ƽ� ����
	//�ϳ��� �����͸� StudentVO�� ���, VO�� ArrayList�� ��Ƽ� ����
	public ArrayList<StudentVO> selectAll(){
		ArrayList<StudentVO> list = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
						"mystudy", "mystudypw");
			//3 Statement �� ����(SQL�� ����)
			String sql = "";
			sql += "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG";
			sql += " FROM STUDENT ";
			sql += " ORDER BY ID ";
			//3-1 PreparedStatment ��ü ����
			pstmt = conn.prepareStatement(sql);
			
			//3-2 SQL����
			rs = pstmt.executeQuery();
			
			//4.SQL �������� ���� ó��
			while (rs.next()) {
				//DB������ �ϳ��� StudentVO�� ���� + ����Ʈ�� �߰�
				StudentVO vo = new StudentVO(rs.getString("ID")
						, rs.getString("NAME"), rs.getInt("KOR")
						, rs.getInt("ENG"), rs.getInt("MATH")
						, rs.getInt("TOT"), rs.getDouble("AVG"));
				
				//����Ʈ�� �߰�
				list.add(vo);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			closeConnStmtRs(conn, pstmt, rs);
		}

		return list;
	}
	public int insertData(String id, String name,
			int kor, int eng, int math, int tot, double avg) {
		int cnt = 0;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
						"mystudy", "mystudypw");
			String sql = "INSERT INTO student " + 
					" (ID, NAME, KOR, ENG, MATH, TOT, AVG) " + 
					" VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, math);
			pstmt.setInt(6, tot);
			pstmt.setDouble(7, avg);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pstmt);
		}
		return cnt;
	}
	public int insertData(StudentVO student) {
		int cnt = 0;
		int tot = student.getMath() + student.getEng() + student.getKor();
		double avg = tot/3;
		cnt = insertData(student.getId(), student.getName(),
				student.getKor(), student.getEng(), student.getMath(),
				tot, avg );
		return cnt;
	}
	
	
	public int deleteData(String id) {
		int cut = 0;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
						"mystudy", "mystudypw");
			String sql = "";
			sql += "DELETE FROM STUDENT WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			cut = pstmt.executeUpdate();
			System.out.println("�����Ǿ����ϴ�.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnStmtRs(conn, pstmt);
		}
		return cut;
	}
	public int deleteData(StudentVO student) {
		int result = 0;
		result = deleteData(student.getId());
		return result;
	}
	
	private void closeConnStmtRs(Connection conn,
			PreparedStatement pstmt) {
		//3 Statement �� ����(SQL�� ����)
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int updateDate(StudentVO student) {
		int cut = 0;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
						"mystudy", "mystudypw");
			String sql = "";
			sql += "UPDATE STUDENT SET  NAME = ?, KOR = ?, ENG = ?, MATH = ?, TOT = ?, AVG = ?  WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getKor());
			pstmt.setInt(3, student.getEng());
			pstmt.setInt(4, student.getMath());
			pstmt.setInt(5, student.getTot());
			pstmt.setDouble(6, student.getAvg());
			pstmt.setString(7, student.getId());
			
			cut = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cut;
	}
	public boolean view() {
		StudentVO std = null;
		String temp = null;
		Scanner scan = new Scanner(System.in);
		int cun = -1;
		System.out.println("0.���κ���1.����2.����3.����.4����");
		while(true) {
			try {
				cun = scan.nextInt();
				if(cun <= 5 && cun >= 0)break;
				System.out.println("0~4������ ���� �Է����ּ���.");
			}catch(InputMismatchException e) {
				System.out.println("�ٽ��Է����ּ���");
				scan = new Scanner(System.in);
				e.printStackTrace();
			}
		}
		scan.nextLine();
		switch(cun) {
		case 0:
			ArrayList<StudentVO> list = selectAll();
			for(StudentVO student : list) {
				System.out.println(student.toString());
//				dispData(student.getId());
			}
			break;
		case 1:
			System.out.println("�Է¿�ûID >>");
			temp = scan.nextLine();
			dispData(temp);
			break;
		case 2:
			std = new StudentVO(null, null, 0, 0, 0);
			System.out.println("���̵� �Է�");
			temp = scan.nextLine();
			if(dispData(temp)) {
				System.out.println("�����ϴ� ���̵��Դϴ�.");
				break;
			}
			std.setId(temp);
			System.out.println("�̸� �Է�");
			std.setName(scan.nextLine());
			scan.nextLine();
			System.out.println("����>");
			std.setKor(scan.nextInt());
			System.out.println("����>");
			std.setEng(scan.nextInt());
			System.out.println("����>");
			std.setMath(scan.nextInt());
			System.out.println(std.toString());
			
			cun = insertData(std);
			System.out.println(cun + " �� ����");
			break;
		case 3:
			System.out.println("�Է¿�ûID >>");
			temp = scan.nextLine();
			deleteData(temp);
			break;
			
		case 4:
			std = new StudentVO(null, null, 0, 0, 0);
			System.out.println("���̵� �Է�");
			temp = scan.nextLine();
			if(!dispData(temp)) {
				System.out.println("�������� �ʴ¾��̵� �Դϴ�.");
				break;
			}
			std.setId(temp);
			System.out.println("�̸� �Է�");
			std.setName(scan.nextLine());
			scan.nextLine();
			System.out.println("����>");
			std.setKor(scan.nextInt());
			System.out.println("����>");
			std.setEng(scan.nextInt());
			System.out.println("����>");
			std.setMath(scan.nextInt());
			System.out.println(std.toString());
			
			cun = updateDate(std);
			System.out.println(cun + " �� ����");
			break;
		case 5:
			scan.close();
			System.out.println("����");
			return false;
		}
		
		return true;
	}
	
}