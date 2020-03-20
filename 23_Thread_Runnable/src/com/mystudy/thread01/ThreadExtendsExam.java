package com.mystudy.thread01;

// 쓰레드로 동작하는 클래스 만들기
//Thread 클래스를 상속확장(extends) 해서 만들기
class ThreadTest extends Thread {
	int num = 10;
	ThreadTest() {}
	ThreadTest(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		// thread클래스의 run() 메소드를 오버라이딩(overriding) 해서
		//스레드로 할려는 작업을 작성 처리
		System.out.println(this.getName() + ">>>>>> 시작");
		for(int i = 1; i <= num; i++){
			System.out.println(this.getName() + " : " + i );
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(">>>>>> 끝");
	}
}


public class ThreadExtendsExam {

	
	
	public static void main(String[] args) {
		System.out.println("--- main() 시작 ----");
		ThreadTest th1 = new ThreadTest();
//		th1.run(); // 단순메소드 호출
		th1.start();//쓰레드로 동작하기위해서 start로 동작
		
		//쓰레드를 하나 더 생성해서 실행
		ThreadTest th2 = new ThreadTest(20);
		th2.start();
		
		System.out.println("--- main()  끝----");
	}

}
