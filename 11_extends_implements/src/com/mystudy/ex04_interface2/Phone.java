package com.mystudy.ex04_interface2;

//�������̽�(interface) ����(implements)�ϴ� ������� Ŭ���� �����
public class Phone implements I_Phone {
	//�ʵ�(�Ӽ�) ---------
	private String type; //��ȭ��Ÿ��(����)
	private String phoneNo; //��ȭ��ȣ
	
	//������ -------------
	//public Phone() {}
	public Phone(String phoneNo) {
		this.type = "Phone Ÿ��";
		this.phoneNo = phoneNo;
	}

	public Phone(String type, String phoneNo) {
		super();
		this.type = type;
		this.phoneNo = phoneNo;
	}
	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getPhoneNo() {
		return phoneNo;
	}

	@Override
	public void call() {
		System.out.println(">> ��ȭ�ɱ�");
	}

	@Override
	public void receiveCall() {
		System.out.println(">> ��ȭ�ޱ�");
	}

	@Override
	public void view() {
		System.out.println("Ÿ�� : " + type + ", ��ȭ��ȣ : " + phoneNo);
	}

	@Override
	public void sendMsg() {
		System.out.println(">> �޽��� ����");
	}

	@Override
	public void receiveMsg() {
		System.out.println(">> �޽��� ����");
	}

}