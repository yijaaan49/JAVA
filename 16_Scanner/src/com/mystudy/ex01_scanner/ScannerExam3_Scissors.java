package com.mystudy.ex01_scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScannerExam3_Scissors {
	public static void main(String[] args) {
		//scanner �� �̿��� ���� ���� �� ����
//		123  2 -1 �Ͻ� �¸�
//		312 -2 1�Ͻ� �¸�
//		0�Ͻ� ���º�
		scissors.displye();
	}
	
}
class scissors{
	private static final Map<Integer, String> HAND = 
			new HashMap<>();
			static{
				HAND.put(1, "����");
				HAND.put(2, "����");
				HAND.put(3, "��");
			}
	private static int comp() {
		int handKey = (int)(Math.random()*3+1);
		System.out.println("��ǻ�ʹ� (" + HAND.get(handKey)
				+ ")�� �½��ϴ�");
		return handKey;
	}
	static void displye() {
		Scanner scan = new Scanner(System.in);
		int playHand;
		int userData[] = new int[2];
		System.out.println("���������� ���� ����");
		System.out.println("1)���� 2)���� 3)��");
		while(true) {
			System.out.print("�Է� >>");
			playHand = scan.nextInt();
			System.out.println("����� (" + HAND.get(playHand) + ")�� �½��ϴ�.");
			playHand -= comp();
			switch(playHand) {
			case 2: case -1:
				System.out.println("����� �й��Դϴ�.");
				userData[0]++;
				break;
			case -2: case 1:
				System.out.println("����� �¸��Դϴ�.");
				userData[1]++;
				break;
			case 0:
				System.out.println("�����ϴ�.");
				continue;
			}
			System.out.println("�¸�Ƚ�� : " + userData[1] + " / �й�Ƚ�� : " + userData[0]);
			System.out.print("replay? yes=1>>");
			if(scan.nextInt() != 1) {
				break;
			}
		}
		scan.close();
	}
	
	
}