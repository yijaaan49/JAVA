package com.mystudy.ex01_scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerExam4 {
	public static void main(String[] args) {
		RandomNum rand = new RandomNum();
		rand.disPlay();
	}
	
}
class RandomNum {
	
	public void disPlay() {
		Scanner scan = new Scanner(System.in);
		System.out.println("====게임시작====");
		
		while(true) {
			random(scan);
			scan.nextLine();
			if(tryAgain(scan)) {
				System.out.println("종료");
				break;
			}
		}
		
		scan.close();
		
	}

	private boolean tryAgain(Scanner scan) {
		System.out.print("그만하시겠습니까? (대문자 Y 를 입력하시오) >>");
		try {
			char temp = scan.nextLine().charAt(0);
				if(temp == 'y' || temp == 'Y') {
				return true;
			}
		}catch (StringIndexOutOfBoundsException e) {
		}
		return false;
	}
	
	private void random(Scanner scan) {
		int numC = (int)(Math.random() * 100 + 1);
		int temp = -1;
		for(int i = 5 ; i > 0 ; i --) {
			System.out.println(i + "회 남음");
			
			do {
				try {
					System.out.print("숫자를 입력해주세요 >");
					temp = scan.nextInt();
					if(temp >= 0 && temp <= 100) {
						break;
					}
					System.out.println("0 ~ 100 사이의 숫자만 입력해주세요");
				}catch(InputMismatchException e) {
					//scan.nextLine();
					System.out.println("정수만 입력가능합니다.");
				}

			}while(true);
			if(temp == numC) {
				System.out.println("축하합니다. 정답입니다.");
				break;
			}else if(i <= 1) {
				break;
			}else {
				System.out.println(numC > temp ? "입력하신 숫자가 작습니다." : "입력하신 숫자가 큽니다.");
			}
		}
		System.out.println("컴퓨터의 숫자는 " + numC + "입니다.");
	}
	
//	private int scanNum (Scanner scan) {
//		return 
//	}
//	
//	private boolean same(int numC, int numP) {
//		System.out.println(numC > numP ? "입력하신 숫자가 작습니다." : 
//				numC < numP ? "입력하신 숫자가 큽니다." : "축하합니다. 정답입니다.");
//		return numC == numP ? true : false ;
//	}
	
}
