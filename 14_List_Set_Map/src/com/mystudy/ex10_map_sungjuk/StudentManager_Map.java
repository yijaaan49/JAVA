package com.mystudy.ex10_map_sungjuk;

import com.mystudy.ex05_hashset_exam.StudentVO;
import java.util.Map;
import java.util.HashMap;

public class StudentManager_Map {

	public static void main(String[] args) {
		/*  Map �� ����� ���� ó��
		1. 3���� �л�����Ÿ(����,����,����,����)�� 
		   StudentVO Ŭ������ �̿��ؼ� �����(�����ϰ�)
		   "ȫ�浿", 100, 90, 81
		   "�̼���", 95, 88, 92
		   "������", 90, 87, 77
		2. Map<String, StudentVO> Ÿ���� ����(map)�� �����ϰ�
		   key: �̸�, value: StudentVO
		3. map�� �ִ� ����Ÿ�� ����ؼ� ȭ�����
		     ����     ����   ����  ����    ����     ���
		   --------------------------
		     ȫ�浿  100  90  81  270  90.33
		   ...
		4. "ȫ�浿" �л���  �������� 88������ ����
		5. "ȫ�浿" �л��� ������ ȭ�� ���
		************************************/
		StudentVO stdData1 = new StudentVO("ȫ�浿", 100, 90, 81);
		StudentVO stdData2 = new StudentVO("�̼���", 95, 88, 92);
		StudentVO stdData3 = new StudentVO("������", 90, 87, 77);
		Map<String, StudentVO> stdMap = new HashMap<>();
		stdMap.put(stdData1.getName(), stdData1);
		stdMap.put(stdData2.getName(), stdData2);
		stdMap.put(stdData3.getName(), stdData3);
		System.out.println("����\t����\t����\t����\t����\t���");
		for(StudentVO key : stdMap.values()) {
			key.printData();
		}
		System.out.println("--------------------------------------");
		stdMap.get("ȫ�浿").setKor(88);
		stdMap.get("ȫ�浿").printData();

	}

}
