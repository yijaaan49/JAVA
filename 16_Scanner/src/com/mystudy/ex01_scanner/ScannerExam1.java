package com.mystudy.ex01_scanner;

import java.util.Scanner;

public class ScannerExam1 {
	public static void main(String[] args) {
		// Scanner : �ַ� �ܼ�(ȭ��)���� ����  �Է¹޾� ó���� �� ���
		Scanner scan = new Scanner(System.in);
		
//		System.out.print("���ڿ� �Է� >>");
//		String str1 = scan.nextLine();
//		System.out.println(">> " + str1);
//		
//		System.out.println("----------");
//		System.out.print("���ڿ� �Է� >>");
//		String str2 = scan.nextLine();
//		System.out.println(">> " + str2);
//		System.out.println("-----------------");
//		System.out.println("---������ 2���� �Է��ϸ� ���� ��� ���---");
//		
//		int num1 = 20;
//		int num2 = 30;
//		int sum = 0;
//		System.out.print("1���� �Է� >");
//		int num1 = scan.nextInt();
//		System.out.print("2���� �Է� >");
//		int num2 = scan.nextInt();
//		
//		sum = num1 + num2;
//		System.out.println(sum);
//		
		System.out.println("=============================");
		System.out.print("�����Է� >>");
		int num = scan.nextInt();
		String str = scan.nextLine();
		System.out.println(num);
	}
}
