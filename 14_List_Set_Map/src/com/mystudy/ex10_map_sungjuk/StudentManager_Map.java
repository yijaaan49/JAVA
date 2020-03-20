package com.mystudy.ex10_map_sungjuk;

import com.mystudy.ex05_hashset_exam.StudentVO;
import java.util.Map;
import java.util.HashMap;

public class StudentManager_Map {

	public static void main(String[] args) {
		/*  Map 을 사용한 성적 처리
		1. 3명의 학생데이타(성명,국어,영어,수학)를 
		   StudentVO 클래스를 이용해서 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		2. Map<String, StudentVO> 타입의 변수(map)에 저장하고
		   key: 이름, value: StudentVO
		3. map에 있는 데이타를 사용해서 화면출력
		     성명     국어   영어  수학    총점     평균
		   --------------------------
		     홍길동  100  90  81  270  90.33
		   ...
		4. "홍길동" 학생의  국어점수 88점으로 수정
		5. "홍길동" 학생의 정보를 화면 출력
		************************************/
		StudentVO stdData1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stdData2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stdData3 = new StudentVO("김유신", 90, 87, 77);
		Map<String, StudentVO> stdMap = new HashMap<>();
		stdMap.put(stdData1.getName(), stdData1);
		stdMap.put(stdData2.getName(), stdData2);
		stdMap.put(stdData3.getName(), stdData3);
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		for(StudentVO key : stdMap.values()) {
			key.printData();
		}
		System.out.println("--------------------------------------");
		stdMap.get("홍길동").setKor(88);
		stdMap.get("홍길동").printData();

	}

}
