package com.mystudy.ipcat;

class threadClass implements Runnable{
	public threadClass() {
		super();
		for(int i = 0 ; i < 10 ; i++)
		System.out.println("aaa");
	}
	public void run () {
		for(int i = 0 ; i < 10 ; i++)
		System.out.println("bbb");
	}
}

public class test1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����");
		threadClass[] tc = new threadClass[5];
		Thread t = new Thread(tc[0]);
		
		
		t.start();
		t = new Thread(tc[1]);
		t.start();
		System.out.println("��");
	}

}
