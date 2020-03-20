package com.mystudy.ex01_scanner;

import java.util.Scanner;

public class ScannerExam1 {
	public static void main(String[] args) {
		// Scanner : 주로 콘솔(화면)에서 값을  입력받아 처리할 때 사용
		Scanner scan = new Scanner(System.in);
		
//		System.out.print("문자열 입력 >>");
//		String str1 = scan.nextLine();
//		System.out.println(">> " + str1);
//		
//		System.out.println("----------");
//		System.out.print("문자열 입력 >>");
//		String str2 = scan.nextLine();
//		System.out.println(">> " + str2);
//		System.out.println("-----------------");
//		System.out.println("---정수값 2개를 입력하면 더한 결과 출력---");
//		
//		int num1 = 20;
//		int num2 = 30;
//		int sum = 0;
//		System.out.print("1번값 입력 >");
//		int num1 = scan.nextInt();
//		System.out.print("2번값 입력 >");
//		int num2 = scan.nextInt();
//		
//		sum = num1 + num2;
//		System.out.println(sum);
//		
		System.out.println("=============================");
		System.out.print("숫자입력 >>");
		int num = scan.nextInt();
		String str = scan.nextLine();
		System.out.println(num);
	}
}
