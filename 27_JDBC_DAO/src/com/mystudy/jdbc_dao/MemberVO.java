package com.mystudy.jdbc_dao;


//VO : Value Object
public class MemberVO {
	//DB�� MEMBER ���̺�� ������ ���� �ʵ� ����
	//ID, NAME, PASSWORD, PHONE, ADDRESS
	private String id = new String();
	private String name = new String();
	private String password = new String();
	private String phone = new String();
	private String address = new String();

	
	//������(id, name, password, phone) 
	public MemberVO() {
		super();
	}
	public MemberVO(String id, String name, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}
	public MemberVO(String id, String name, String password, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	
	//getter setter private �̹Ƿ� �����ؾ��Ѵ�
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", address="
				+ address + "]";
	}
	
}