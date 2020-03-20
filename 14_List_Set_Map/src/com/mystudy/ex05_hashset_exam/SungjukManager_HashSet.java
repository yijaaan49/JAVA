package com.mystudy.ex05_hashset_exam;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

public class SungjukManager_HashSet {

	public static void main(String[] args) throws Exception {
		/*  Set을 사용한 성적 처리
		1. 3명의 학생데이타(성명,국어,영어,수학)를 
		   StudentVO 클래스를 이용해서 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		2. HashSet<StudentVO> 타입의 변수(set)에 저장하고
		3. set에 있는 데이타를 사용해서 화면출력
		     성명     국어   영어  수학    총점     평균
		   --------------------------
		     홍길동  100  90  81  270  90.33
		   ...
		4. "홍길동" 학생의  국어점수 88점으로 수정
		5. "홍길동" 학생의 정보를 화면 출력
		************************************/
		Scanner scan = new Scanner(System.in);
		StudentVO stdData1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stdData2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stdData3 = new StudentVO("김유신", 90, 87, 77);
		Set <StudentVO> setStd = new HashSet<StudentVO>();
		
		setStd.add(stdData1);
		setStd.add(stdData2);
		setStd.add(stdData3);
		
			sc(scan);

		Iterator<StudentVO> ite = setStd.iterator();
		
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		while(ite.hasNext()) {
			StudentVO temp = ite.next();
			temp.printData();

			}
		ite = setStd.iterator();
		System.out.println("------------------");
		while(ite.hasNext()) {
			StudentVO temp = ite.next();
			if(temp.getName().equals("홍길동")) {
				temp.setKor(88);
				temp.printData();
			}
		}
		ite = setStd.iterator();
		
		scan.close();
	}

	public static void sc (Scanner scan) throws Exception {	
		int temp = scan.nextInt();
		System.out.println(temp);
	}
}







