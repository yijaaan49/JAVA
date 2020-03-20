package com.mystudy.ex03_scanner_bank;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class BankATM {
	private int money;
	private ArrayList<String> bankData = new ArrayList<>();
	
	public void bankDisplay() {
		Scanner scan = new Scanner(System.in);
		int scanNum;
		while(true) {
			hallow();
			do {
				System.out.print(">>작업선택 : ");
				scanNum = intType(scan);
				if(scanNum >= 0 && scanNum <= 3) {
					break;
				}
				System.out.println("존재하지 않는 기능입니다. 다시 입력해주세요");
			} while(true); //맨위값 입력
			
			switch(scanNum) {
			case 1:
				inMoney (scan);
				break;
			case 2:
				outMoney(scan);
				totMoney();
				break;
			case 3:
				myBank();
				break;
			default:
				
				System.out.println("===================");
				System.out.println("===================");
				System.out.println("======종료됩니다======");
				System.out.println("===================");
				System.out.println("===================");
				scan.close();
				return;
			}
		}
		
	}
	
	private void inMoney (Scanner scan) {
		System.out.print(">>입금액 : ");
		int temp = intType(scan);
		this.money += temp;
		totMoney();
		getBankData(temp);
	}
	
	private void outMoney(Scanner scan) {
		System.out.print(">>출금액 : ");
		int temp = intType(scan);
		if(this.money < temp) {
			System.out.println("통장 잔고보다 더 많은 돈을 뽑을 수 없습니다.");
			return;
		}
		temp *= -1;
		this.money += temp;
		getBankData(temp);
	}
	
	private void totMoney() {
		System.out.println("통장금액 : " + money);
	}
	
	private void hallow() {
		System.out.println("========================");
		System.out.println("1.입금 2.출금 3.통장확인 0.종료");
		System.out.println("========================");
	}
	private int intType(Scanner scan) {
		do {
			try {
				return scan.nextInt();
			}
			catch(InputMismatchException E) {
				System.out.println("에러 발생 다시 입력해주세요");
				scan.nextLine();
				System.out.print(">>");
			}
		}while(true);
	}
	private void myBank() {
		System.out.println("통장 잔고를 확인합니다.");
		for(String temp : bankData) {
			System.out.println(temp);
		}
		totMoney();
	}
	
	private void getBankData(int moneyData) {
		StringBuilder saveData = new StringBuilder();
		if(moneyData < 0) {
			saveData.append("출금 : ");
			moneyData *= -1;
		}else {
			saveData.append("입금 : ");
		}
		saveData.append(Integer.toString(moneyData));
		bankData.add(saveData.toString());
	}
}
