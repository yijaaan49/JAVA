package com.mystudy.thread01;

// ������� �����ϴ� Ŭ���� �����
//Thread Ŭ������ ���Ȯ��(extends) �ؼ� �����
class ThreadTest extends Thread {
	int num = 10;
	ThreadTest() {}
	ThreadTest(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		// threadŬ������ run() �޼ҵ带 �������̵�(overriding) �ؼ�
		//������� �ҷ��� �۾��� �ۼ� ó��
		System.out.println(this.getName() + ">>>>>> ����");
		for(int i = 1; i <= num; i++){
			System.out.println(this.getName() + " : " + i );
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(">>>>>> ��");
	}
}


public class ThreadExtendsExam {

	
	
	public static void main(String[] args) {
		System.out.println("--- main() ���� ----");
		ThreadTest th1 = new ThreadTest();
//		th1.run(); // �ܼ��޼ҵ� ȣ��
		th1.start();//������� �����ϱ����ؼ� start�� ����
		
		//�����带 �ϳ� �� �����ؼ� ����
		ThreadTest th2 = new ThreadTest(20);
		th2.start();
		
		System.out.println("--- main()  ��----");
	}

}
