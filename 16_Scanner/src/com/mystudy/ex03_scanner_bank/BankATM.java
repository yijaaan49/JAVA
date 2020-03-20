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
				System.out.print(">>�۾����� : ");
				scanNum = intType(scan);
				if(scanNum >= 0 && scanNum <= 3) {
					break;
				}
				System.out.println("�������� �ʴ� ����Դϴ�. �ٽ� �Է����ּ���");
			} while(true); //������ �Է�
			
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
				System.out.println("======����˴ϴ�======");
				System.out.println("===================");
				System.out.println("===================");
				scan.close();
				return;
			}
		}
		
	}
	
	private void inMoney (Scanner scan) {
		System.out.print(">>�Աݾ� : ");
		int temp = intType(scan);
		this.money += temp;
		totMoney();
		getBankData(temp);
	}
	
	private void outMoney(Scanner scan) {
		System.out.print(">>��ݾ� : ");
		int temp = intType(scan);
		if(this.money < temp) {
			System.out.println("���� �ܰ��� �� ���� ���� ���� �� �����ϴ�.");
			return;
		}
		temp *= -1;
		this.money += temp;
		getBankData(temp);
	}
	
	private void totMoney() {
		System.out.println("����ݾ� : " + money);
	}
	
	private void hallow() {
		System.out.println("========================");
		System.out.println("1.�Ա� 2.��� 3.����Ȯ�� 0.����");
		System.out.println("========================");
	}
	private int intType(Scanner scan) {
		do {
			try {
				return scan.nextInt();
			}
			catch(InputMismatchException E) {
				System.out.println("���� �߻� �ٽ� �Է����ּ���");
				scan.nextLine();
				System.out.print(">>");
			}
		}while(true);
	}
	private void myBank() {
		System.out.println("���� �ܰ� Ȯ���մϴ�.");
		for(String temp : bankData) {
			System.out.println(temp);
		}
		totMoney();
	}
	
	private void getBankData(int moneyData) {
		StringBuilder saveData = new StringBuilder();
		if(moneyData < 0) {
			saveData.append("��� : ");
			moneyData *= -1;
		}else {
			saveData.append("�Ա� : ");
		}
		saveData.append(Integer.toString(moneyData));
		bankData.add(saveData.toString());
	}
}
