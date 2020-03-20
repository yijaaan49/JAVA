package com.bankplay;

//import java.util.Stack;

class AccountVO {

	String userName = new String(); //사용자 이름
	String userAccount = new String(); //사용자 계좌
	int userRank ; //신용등급 1~9
	int userMoney ; //사용자 돈
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
