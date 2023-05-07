package com.mscs.user;

public class UserDetails {

	int UserCardId;
	String UserName;
	double UserBalance;
	
	public UserDetails(int userCardId, String userName, double userBalance) {
		super();
		UserCardId = userCardId;
		UserName = userName;
		UserBalance = userBalance;
	}
	
	public int getUserCardId() {
		return UserCardId;
	}

	public void setUserCardId(int userCardId) {
		UserCardId = userCardId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public double getUserBalance() {
		return UserBalance;
	}

	public void setUserBalance(double userBalance) {
		UserBalance = userBalance;
	}
	
}
