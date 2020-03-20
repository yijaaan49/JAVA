package com.bankplay;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ATM_system {
	static Scanner scan = new Scanner(System.in);
	
	static Map<String ,AccountVO> accountMap = new HashMap<>();
	static public void ATMdisplay() {
		
		while(interFace());
	}
	
	private static boolean interFace() {
		int temp = -1;
		System.out.println("======================");
		System.out.println("======================");
		System.out.println("======================");
		
		 do{
			try {
				System.out.print(">>");
				temp = scan.nextInt();
				
			}catch (InputMismatchException e) {
				scan = new Scanner(System.in);
				System.out.println("���� �߻� �ٽ��Է����ּ���.");
			}
			if(temp > 0 || temp < 3) break;
			System.out.println("1~3 ������ ���� �Է����ּ���");
		}while(true);
		switch (temp) {
		case 1:
			dataInput ();
			break;

		case 2:
			System.out.println(accountMap.keySet());
			return true;
		}
		return true;
	}
	
	void controlFace() {
		
	}
	static void dataInput () {
		AccountVO account = new AccountVO();
		scan = new Scanner(System.in);
		System.out.println("���� ��ȣ���Է����ּ��� ");
		System.out.print(">>");
		account.setUserAccount(scan.nextLine());
		System.out.println("�̸��� �Է����ּ��� ");
		System.out.print(">>");
		account.setUserName(scan.nextLine());
		System.out.println("������ �� ");
		System.out.print(">>");
		scan = new Scanner(System.in);
		account.setUserMoney(scan.nextInt());
		System.out.println("����� ��� 1~9");
		System.out.print(">>");
		account.setUserRank(scan.nextInt());
		accountMap.put(account.getUserAccount(), account);
	}
	
}