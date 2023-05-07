package com.demo.empapp.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.demo.empapp.entity.Employee;

public class EmployeeServiceImpl implements EmployeeServiceInterface {

	Set<Employee> employees = new HashSet<Employee>();

	@Override
	public void createEmployee(Employee emp) {
		employees.add(emp);
	}

	@Override
	public void updateEmployee(int id, String name) {
		Iterator<Employee> iterator = employees.iterator();
		boolean employeeFound = false;
		while (iterator.hasNext()) {
			Employee emp = (Employee) iterator.next();
			if (emp.getId() == id) {
				emp.setName(name);
				employeeFound = true;
				break;
			}
		}
		if (!employeeFound)
			System.out.println("Employee not found\n");
	}

	@Override
	public void deleteEmployee(int id) {
		Iterator<Employee> iterator = employees.iterator();
		boolean employeeFound = false;
		while (iterator.hasNext()) {
			Employee emp = (Employee) iterator.next();
			if (emp.getId() == id) {
				employees.remove(emp);
				employeeFound = true;
				break;
			}
		}
		if (!employeeFound)
			System.out.println("Employee not found\n");
	}

	@Override
	public void loadAllEmployees() {
		String csvFile = "Data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] employee = line.split(cvsSplitBy);
				employees.add(new Employee(Integer.parseInt(employee[0]), employee[1], Double.parseDouble(employee[2]),
						Integer.parseInt(employee[3])));
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("Exception : " + e);
				}
			}
		}
	}

	@Override
	public void showAllEmployee() {
		Iterator<Employee> iterator = employees.iterator();
		System.out.println("Employee Details");
		System.out.println("===============================================================");

		while (iterator.hasNext()) {
			Employee emp = (Employee) iterator.next();
			System.out.println("Employee = " + emp.toString());
		}
		System.out.println("===============================================================\n");
	}

	@Override
	public void showEmployeeBasedOnID(int id) {
		Iterator<Employee> iterator = employees.iterator();
		boolean employeeFound = false;
		while (iterator.hasNext()) {
			Employee emp = (Employee) iterator.next();
			if (emp.getId() == id) {
				System.out.println("Employee Details");
				System.out.println("===============================================================");
				System.out.println(emp.toString());
				System.out.println("===============================================================");
				employeeFound = true;
				break;
			}
		}
		if (!employeeFound)
			System.out.println("Employee not found\n");
	}
}
