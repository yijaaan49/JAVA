package com.mystudy.ex01_generic;

class BoxT<T> {
	T obj;
	void setObj(T obj) {this.obj = obj;}
	T getObj() {return obj;}
}

public class GenericWildcardExam {
	public static void main(String[] args) {
		//���׸� (Generic) : ���ϵ� ī�� (Wildcard - ��ǥ����)
		//1. <?> : ���Ÿ�� ( ��ü ) �ڷ����� ���� ��ǥ���ڸ� �ǹ�
		//2. <? extends �ڷ���> : �ڷ����� ��ӹ��� ����(sub) Ŭ���� Ÿ�� ���
		//3. <? super �ڷ��� > : �ڷ����� ���� (super) Ÿ�� ���
		//------------------------------------------------
		BoxT<String> box1 = new BoxT<> ();
		box1.setObj("String Ÿ��");
		
		BoxT<Integer> box2 = new BoxT<>();
//		box2.setObj("���ڿ�"); // ������ ����
//		box2.setObj(100.0); // double Ÿ������ ���� ������ ����
		box2.setObj(100);
		box2.setObj(new Integer(1000));
		System.out.println(box2.getObj());
		System.out.println("----------------------------------------");
		//<?> ��� ���� ���� �� �ִ� ����(Object�� ������ ȿ��)
		BoxT<?> box3 = new BoxT<String>();
		box3 = new BoxT<Integer>();
		box3 = new BoxT<StringBuilder>();
		
		//<? extends �ڷ���> : �ڷ��� ���� sub Ÿ��(extends �� Ÿ�Ե� ��� ����)
		BoxT<? extends Number> box10 = null; // Number ���ȭ���� ������ Ÿ��
		box10 = new BoxT<Number>();
		box10 = new BoxT<Integer>();
		box10 = new BoxT<Short>();
		box10 = new BoxT<Double>();
//		box10 = new BoxT<String>(); // Number �ڷ����� String Ÿ���� ������ ���� �ʴ´�;
		
		BoxT<? super Number> box20 = null; //�ڷ��� ���� ����(super) Ÿ�� ��� ����
		box20 = new BoxT<Number>();
		box20 = new BoxT<Object>();
		
		//������ ���� : Type mismatch
//		box20 = new BoxT<Integer>();
	}
}
