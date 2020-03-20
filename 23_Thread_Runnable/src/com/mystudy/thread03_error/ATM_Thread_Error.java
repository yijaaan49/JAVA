package com.mystudy.thread03_error;
class ATM_Error implements Runnable{
	int money;
	public ATM_Error() {} 
	public ATM_Error(int money) { 
		this.money = money;
	}
	
	void add(int money) {
		this.money += money;
		System.out.println(Thread.currentThread()
				+ "�Ա�: " + money + ", �����ܾ� : " + this.money);
	}
	//���
	void out(int money) {
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
public class ATM_Thread_Error {
	
	
	
	
	public static void main(String[] args) {
		System.out.println("���ν���");
		ATM_Error bank = new ATM_Error();
		System.out.println("�����ܰ� : " + bank);
		
		Thread th1 = new Thread(bank, "ATM-1");
		Thread th2 = new Thread(bank, "ATM-100");
		th1.start();
		th2.start();
		
		
		System.out.println("��������");
	}
}
