package com.demo.empapp;

import java.util.Scanner;

import com.demo.empapp.entity.Employee;
import com.demo.empapp.service.EmployeeServiceImpl;
import com.demo.empapp.service.EmployeeServiceInterface;

public class EmployeeMain {
	public static void main(String[] args) {
		EmployeeServiceInterface service = new EmployeeServiceImpl();
		System.out.println("Welcome to Employee management application");
		service.loadAllEmployees();
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("1. Add Employee\n" + "2. Show All Employee\n" + "3. Show Employee based on id \n"
						+ "4. Update the employee\n" + "5. Delete the employee\n"+ "6. Exit\n");

				System.out.println("Enter Choice: ");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					Employee emp = new Employee();
					System.out.println("Enter ID : ");
					int id = sc.nextInt();
					System.out.println("Enter name ");
					String name = sc.next();
					System.out.println("Enter Salary ");
					double salary = sc.nextDouble();
					System.out.println("Enter age");
					int age = sc.nextInt();
					emp.setId(id);
					emp.setName(name);
					emp.setSalary(salary);
					emp.setAge(age);
					service.createEmployee(emp);
					break;
				case 2:
					service.showAllEmployee();
					break;
				case 3:
					System.out.println("Enter id to show the details ");
					int empid = sc.nextInt();
					service.showEmployeeBasedOnID(empid);
					break;
				case 4:
					System.out.println("Enter id to update the details");
					int empid1 = sc.nextInt();
					System.out.println("Enter the new name");
					name = sc.next();
					service.updateEmployee(empid1, name);
					break;
				case 5:
					System.out.println("Enter the id to delete");
					id = sc.nextInt();
					service.deleteEmployee(id);
					break;
				case 6:
					System.out.println("Thank you for using our Application !!!");
					System.exit(0);
				default:
					System.out.println("Enter valid choice !");
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
