
package com.mystudy.thread03_error;
class ATM_Error_Sync implements Runnable{
	int money;
	public ATM_Error_Sync() {} 
	public ATM_Error_Sync(int money) { 
		this.money = money;
	}
	//�Ա�
	//synchronized ���� : �޼ҵ尡 ����Ǵ� ���� ����ȭ ó��
	//�ϳ��� �����尡 �޼ҵ带 ����ϰ� �ִ� ���� ������ ����
	//�ٸ� �����忡�� ����ҷ��� �Ҷ� �����°� ��(�ʵ尪�� ���� ����ȭ)
	synchronized void add(int money) {
		this.money += money;
		System.out.println(Thread.currentThread()
				+ "�Ա�: " + money + ", �����ܾ� : " + this.money);
	}
	//���
	synchronized void out(int money) {
		this.money -= money;
		System.out.println(Thread.currentThread()
				+ "���: " + money + ", �����ܾ� : " + this.money);
	}
	@SuppressWarnings("static-access")
	void bankSleep(int millisecond) {
		try {
			Thread.currentThread().sleep(millisecond);
		} catch (InterruptedException e) {	}
	}
	
	@Override
	public void run() {
		add(1000);
		bankSleep(1000);
		out(500);
		bankSleep(1000);
		out(300);
		bankSleep(1000);
		out(200);
	}
}
public class ATM_Thread_Error_Sync {
	
	
	
	
	public static void main(String[] args) {
		System.out.println("���ν���");
		ATM_Error_Sync bank = new ATM_Error_Sync();
		System.out.println("�����ܰ� : " + bank);
		
		Thread th1 = new Thread(bank, "ATM-1");
		Thread th2 = new Thread(bank, "ATM-100");
		th1.start();
		th2.start();
		
		
		System.out.println("��������");
	}
}
