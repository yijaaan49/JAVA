package com.mystudy.ex01_scanner;

import java.util.Scanner;

public class ScannerExam2 {
	public static void main(String[] args) {
		// ����, ����, ����, ���� ������ ȭ�鿡�� �Է¹޾�
		// ����, ����� ���ϰ� ����� ȭ�� ���
		/*
		 * ���� : ȫ�浿
		 * ���� : 100
		 * ���� : 90
		 * ���� : 81
		 * ------------
		 * ���� : 271
		 * ��� : 90.33
		 * �򰡰�� : A
		 */
		String userName = new String();
		int kor;
		int eng;
		int math;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("���� : ");
			userName = scan.nextLine();
			System.out.print("���� : ");
			kor = scan.nextInt();
			System.out.print("���� : ");
			eng = scan.nextInt();
			System.out.print("���� : ");
			math = scan.nextInt();
			System.out.println("----------");
			//�������
			int total = kor + eng + math;
			double avr = (int)(total/3.0 * 100 + 0.5)/100.0;
			System.out.println("���� : " + total);
			System.out.println("��� : " + avr);
			avr = avr >= 100 ? 99 : avr;
			char userRank = (char)(74 - (avr > 40 ? (int)avr / 10 : 4));
			System.out.println("�� ��� : " + userRank);
			System.out.println();
			System.out.print(">");
			if(scan.nextInt() == 1) {
				break;
			}
			scan.nextLine();
		}
		scan.close();
	}
}