package com.mystudy.jdbc_dao;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO_Test {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
//		List<MemberVO> list = dao.selectAll();
//		for(MemberVO mvo : list) {
//			System.out.println(mvo.toString());
//		}
//		boolean isExist = dao.checkIdPassword("hong4", "1234");
//		if(isExist) {
//			System.out.println("����");
//		}else {
//			System.out.println("����");
//		}
//		//�������� ������ �Է� (list �� �����ؼ�)
//		List<MemberVO> insertList = new ArrayList<MemberVO>();
//		insertList.add(new MemberVO("hong22", "ȫ�浿22", "1234", "010-2222-1111"));
//		insertList.add(new MemberVO("hong33", "ȫ�浿33", "1234", "010-2222-1111"));
//		insertList.add(new MemberVO("hong8", "ȫ�浿8", "1234", "010-2222-1111"));
//		insertList.add(new MemberVO("hong11", "ȫ�浿11", "1234", "010-2222-1111"));
//		
//		int cnt = dao.insertOne(insertList);
//		System.out.println(">>�ϰ��Է°Ǽ� : " + cnt);
		
		List<String> idList = new ArrayList<String>();
		idList.add(new String("hong22"));
		idList.add(new String("hong33"));
		idList.add(new String("hong11"));
		idList.add(new String("hong91"));
		
		int cnt1 = dao.deleteList(idList);
		System.out.println(cnt1);
	}
}
