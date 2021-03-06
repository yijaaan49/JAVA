package com.mystudy.ex01_scanner;

import java.util.Scanner;

public class ScannerExam2 {
	public static void main(String[] args) {
		// 성명, 국어, 영어, 수학 점수를 화면에서 입력받아
		// 총점, 평균을 구하고 결과를 화면 출력
		/*
		 * 성명 : 홍길동
		 * 국어 : 100
		 * 영어 : 90
		 * 수학 : 81
		 * ------------
		 * 총점 : 271
		 * 평균 : 90.33
		 * 평가결과 : A
		 */
		String userName = new String();
		int kor;
		int eng;
		int math;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("성명 : ");
			userName = scan.nextLine();
			System.out.print("국어 : ");
			kor = scan.nextInt();
			System.out.print("영어 : ");
			eng = scan.nextInt();
			System.out.print("수학 : ");
			math = scan.nextInt();
			System.out.println("----------");
			//총점계산
			int total = kor + eng + math;
			double avr = (int)(total/3.0 * 100 + 0.5)/100.0;
			System.out.println("총점 : " + total);
			System.out.println("평균 : " + avr);
			avr = avr >= 100 ? 99 : avr;
			char userRank = (char)(74 - (avr > 40 ? (int)avr / 10 : 4));
			System.out.println("평가 결과 : " + userRank);
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
