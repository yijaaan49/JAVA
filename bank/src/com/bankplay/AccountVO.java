package com.bankplay;

//import java.util.Stack;

class AccountVO {

	String userName = new String(); //����� �̸�
	String userAccount = new String(); //����� ����
	int userRank ; //�ſ��� 1~9
	int userMoney ; //����� ��
//	Stack<String> userData = new Stack<>();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public int getUserRank() {
		return userRank;
	}
	public void setUserRank(int userRank) {
		this.userRank = userRank;
	}
	public int getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(int userMoney) {
		this.userMoney = userMoney;
	}
	
	
}
