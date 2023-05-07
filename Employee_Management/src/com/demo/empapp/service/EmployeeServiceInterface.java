package com.demo.empapp.service;

import com.demo.empapp.entity.Employee;

public interface EmployeeServiceInterface {

	// create employee
	public void createEmployee(Employee emp);

	// show all employee
	public void showAllEmployee();

	// show employee based on id
	public void showEmployeeBasedOnID(int id);

	// update employee
	public void updateEmployee(int id, String name);

	// delete employee
	public void deleteEmployee(int id);

	// load employee
	public void loadAllEmployees();
}
