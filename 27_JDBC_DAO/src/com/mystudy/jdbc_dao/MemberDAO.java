package com.mystudy.jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO , Dao : Date Access Object / Database Access Object
//������(�����ͺ��̽�-DB)�� �����ؼ� CRUD�� ������ Ŭ����
public class MemberDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "mystudy";
	private static final String PASSWORD = "mystudypw";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//����̹� �ε� ó��
	//static �ʱ�ȭ ����
	static {
		try {
			Class.forName(DRIVER);
			System.out.println(">> JDBC ����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("[���ܹ߻�] ����̹� �ε� ����!!");
		}
		
	}
	//SELECT : ���̺� ��ü ������ ��ȸ - selectAll : List<MemberVO>
	//SELECT : �ϳ��� ������ ��ȸ(ID) - selectOne : MemberVO
	//SELECT : �ϳ��� ������ ��ȸ(VO) - selectOne : MemberVO
	//INSERT : VO��ü�� �޾Ƽ� �Է� - insertOne : int
	//UPDATE : VO��ü�� �޾Ƽ� ���� - updateOne : int
	//DELETE : VO��ü�� �޾Ƽ� ���� - deleteOne : int
	//DELETE : Ű��(ID) �޾Ƽ� ���� - deleteOne : int
	
	//�α���ó�� : id, password ���� �޾Ƽ� ������ �����Ͱ� ������ ture ��ȯ
			//������ false ����
	//boolean checkIdPassword(id, password)
	//---------------------------------------------
	
	//SELECT : ���̺� ��ü ������ ��ȸ - selectAll : List<MemberVO>
	public List<MemberVO> selectAll() {
		List<MemberVO> list = new ArrayList<>();
		
		try {
			//DB���� - Connection ��ü ����(DB�� �����)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//PreparedStatement ��ü �����ϰ� SQL�� ����
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS ");
			sql.append(" FROM MEMBER ");
			sql.append(" ORDER BY ID");
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			//SQL �� ���� ����� ���� ó��
			while (rs.next()) {
				/*
				MemberVO mvo = new MemberVO(
						rs.getString("ID"),
						rs.getString("NAME"),
						rs.getString("PASSWORD"),
						rs.getString("ADDRESS") );
				list.add(mvo);
				//���Ʒ� ������ �۾�
				*/
				list.add(new MemberVO());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//��밴ü close
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//INSERT : VO��ü�� �޾Ƽ� �Է� - insertOne : int
	public int insertOne (MemberVO member) {
		int result = 0;
		
		
		
		try {
			//DB���� - Connection ��ü ����(DB�� �����)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL������ �ۼ��ؼ� Statement�� �����ϰ� SQL�� ���� ��û
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER ");
			sql.append(" (ID, NAME, PASSWORD, PHONE, ADDRESS) ");
			sql.append(" VALUES (?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			
			// ? (���ε�����)�� �� ��Ī ��Ű��
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddress());
			//SQL ���� ��û - INSERT, UPDATE, DELETE : executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt);
		}
		
		return result;
	}
	

	public boolean checkIdPassword(String id, String password) {
		boolean result = false;
		try {
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//�α���ó�� : id, password ���� �޾Ƽ� ������ �����Ͱ� ������ ture ��ȯ
			//������ false ����
			//boolean checkIdPassword(id, password)
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS ");
			sql.append(" FROM MEMBER ");
			sql.append(" WHERE ID = ? AND PASSWORD = ?");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) { //�����Ͱ� ������
				System.out.println(">> �����Ͱ� �����մϴ�.");
				result = true;
			}else {
				System.out.println(">> �����Ͱ� �������� �ʽ��ϴ�.");	
				result = false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	//INSERT : List<MemberVO>��ü�� �޾Ƽ� �Է� - insertOne : int
	public int insertOne (List<MemberVO> list) {
		int result = 0;
		
		
		
		try {
			//DB���� - Connection ��ü ����(DB�� �����)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL������ �ۼ��ؼ� Statement�� �����ϰ� SQL�� ���� ��û
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER ");
			sql.append(" (ID, NAME, PASSWORD, PHONE, ADDRESS) ");
			sql.append(" VALUES (?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
//			Autocomit ����
			System.out.println("Autocomit ����" + conn.getAutoCommit());
			//Ʈ����� ó���� ���� autocommit ����
			conn.setAutoCommit(false);
			for(MemberVO member : list) {
				// ? (���ε�����)�� �� ��Ī ��Ű��
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getPassword());
				pstmt.setString(4, member.getPhone());
				pstmt.setString(5, member.getAddress());
				//SQL ���� ��û - INSERT, UPDATE, DELETE : executeUpdate()
//				try {
					result += pstmt.executeUpdate();
					System.out.println(">�Է¼��� : " + member.getId());
//				}catch(SQLException e) {
//					System.out.println(member.getId()  + "�����߻�");
//				}
				conn.commit();
				conn.setAutoCommit(true);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				System.out.println("�ѹ�");
				conn.setAutoCommit(true);
				result = 0;
			} catch (SQLException e1) {
				System.out.println("Ŀ�Խ���");
				e1.printStackTrace();
			}
			System.out.println("�Է½���");
		} finally {
			System.out.println(result + " �� ����");
			JDBC_Close.closeConnStmtRs(conn, pstmt);
		}
		
		return result;
	}
	public int deleteList(List<String> list) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM MEMBER ");
			sql.append("WHERE ID = ?");
			pstmt = conn.prepareStatement(sql.toString());
			for(String id : list) {
				pstmt.setString(1, id);
				try {
					result += pstmt.executeUpdate();
					System.out.println(id + " �� ���� ����");
				} catch (SQLException e) {
					System.out.println(id + " �� �������� �ʽ��ϴ�");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt);
		}
		
		
		return result;
	}

}