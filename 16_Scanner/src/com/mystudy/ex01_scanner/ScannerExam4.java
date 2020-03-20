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
		System.out.println("====���ӽ���====");
		
		while(true) {
			random(scan);
			scan.nextLine();
			if(tryAgain(scan)) {
				System.out.println("����");
				break;
			}
		}
		
		scan.close();
		
	}

	private boolean tryAgain(Scanner scan) {
		System.out.print("�׸��Ͻðڽ��ϱ�? (�빮�� Y �� �Է��Ͻÿ�) >>");
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
			System.out.println(i + "ȸ ����");
			
			do {
				try {
					System.out.print("���ڸ� �Է����ּ��� >");
					temp = scan.nextInt();
					if(temp >= 0 && temp <= 100) {
						break;
					}
					System.out.println("0 ~ 100 ������ ���ڸ� �Է����ּ���");
				}catch(InputMismatchException e) {
					//scan.nextLine();
					System.out.println("������ �Է°����մϴ�.");
				}

			}while(true);
			if(temp == numC) {
				System.out.println("�����մϴ�. �����Դϴ�.");
				break;
			}else if(i <= 1) {
				break;
			}else {
				System.out.println(numC > temp ? "�Է��Ͻ� ���ڰ� �۽��ϴ�." : "�Է��Ͻ� ���ڰ� Ů�ϴ�.");
			}
		}
		System.out.println("��ǻ���� ���ڴ� " + numC + "�Դϴ�.");
	}
	
//	private int scanNum (Scanner scan) {
//		return 
//	}
//	
//	private boolean same(int numC, int numP) {
//		System.out.println(numC > numP ? "�Է��Ͻ� ���ڰ� �۽��ϴ�." : 
//				numC < numP ? "�Է��Ͻ� ���ڰ� Ů�ϴ�." : "�����մϴ�. �����Դϴ�.");
//		return numC == numP ? true : false ;
//	}
	
}
