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
//			System.out.println("있음");
//		}else {
//			System.out.println("없음");
//		}
//		//여러개의 데이터 입력 (list 를 전달해서)
//		List<MemberVO> insertList = new ArrayList<MemberVO>();
//		insertList.add(new MemberVO("hong22", "홍길동22", "1234", "010-2222-1111"));
//		insertList.add(new MemberVO("hong33", "홍길동33", "1234", "010-2222-1111"));
//		insertList.add(new MemberVO("hong8", "홍길동8", "1234", "010-2222-1111"));
//		insertList.add(new MemberVO("hong11", "홍길동11", "1234", "010-2222-1111"));
//		
//		int cnt = dao.insertOne(insertList);
//		System.out.println(">>일괄입력건수 : " + cnt);
		
		List<String> idList = new ArrayList<String>();
		idList.add(new String("hong22"));
		idList.add(new String("hong33"));
		idList.add(new String("hong11"));
		idList.add(new String("hong91"));
		
		int cnt1 = dao.deleteList(idList);
		System.out.println(cnt1);
	}
}
