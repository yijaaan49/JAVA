package com.mystudy.ex05_hashset_exam;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

public class SungjukManager_HashSet {

	public static void main(String[] args) throws Exception {
		/*  Set�� ����� ���� ó��
		1. 3���� �л�����Ÿ(����,����,����,����)�� 
		   StudentVO Ŭ������ �̿��ؼ� �����(�����ϰ�)
		   "ȫ�浿", 100, 90, 81
		   "�̼���", 95, 88, 92
		   "������", 90, 87, 77
		2. HashSet<StudentVO> Ÿ���� ����(set)�� �����ϰ�
		3. set�� �ִ� ����Ÿ�� ����ؼ� ȭ�����
		     ����     ����   ����  ����    ����     ���
		   --------------------------
		     ȫ�浿  100  90  81  270  90.33
		   ...
		4. "ȫ�浿" �л���  �������� 88������ ����
		5. "ȫ�浿" �л��� ������ ȭ�� ���
		************************************/
		Scanner scan = new Scanner(System.in);
		StudentVO stdData1 = new StudentVO("ȫ�浿", 100, 90, 81);
		StudentVO stdData2 = new StudentVO("�̼���", 95, 88, 92);
		StudentVO stdData3 = new StudentVO("������", 90, 87, 77);
		Set <StudentVO> setStd = new HashSet<StudentVO>();
		
		setStd.add(stdData1);
		setStd.add(stdData2);
		setStd.add(stdData3);
		
			sc(scan);

		Iterator<StudentVO> ite = setStd.iterator();
		
		System.out.println("����\t����\t����\t����\t����\t���");
		while(ite.hasNext()) {
			StudentVO temp = ite.next();
			temp.printData();

			}
		ite = setStd.iterator();
		System.out.println("------------------");
		while(ite.hasNext()) {
			StudentVO temp = ite.next();
			if(temp.getName().equals("ȫ�浿")) {
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






