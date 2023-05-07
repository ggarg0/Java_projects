package com.mscs.user;

public class NonEmployee extends User {
	private int employeeId;
	boolean isEmployee;

	public NonEmployee(int userCardId, String userName, double userBalance, int employeeId, boolean isEmployee) {
		super(userCardId, userName, userBalance);
		this.employeeId = employeeId;
		this.isEmployee = isEmployee;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
}
