package test;

public class mainTest {
	static int a = 1;
	static int b = 2;
	
	public static int sum() {
		a = 2;
		b = 4;
		return a+b;
	}
	
	public static int sub() {
		return b-a;
	}
	
	
	public static void main(String[] args) {
		System.out.println(sum());
		System.out.println(sub());
	}
}
