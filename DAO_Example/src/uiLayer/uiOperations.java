package uiLayer;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import DTOLayer.Employee;
import DTOLayer.EmployeeImpl;
import ExceptionLayer.NoRecordFoundException;
import ExceptionLayer.SomethingWentWrongException;
import daoLayer.EmployeeDAO;
import daoLayer.EmployeeDAOImpl;

public class uiOperations {
	
	public static void addEmployeeOp(Scanner sc) {
		
				
		//code to take input
		System.out.print("Enter employee id: ");
		String eid = sc.next();
		
		System.out.print("Enter employee name: ");
		String name = sc.next();
		
		System.out.print("Enter employee salary: ");
		double salary = sc.nextDouble();
		
		System.out.print("Enter joining date: ");
		LocalDate joiningDate = LocalDate.parse(sc.next());
		
		Employee employee = new EmployeeImpl(eid, name, salary, joiningDate);
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		try {
			empDAO.addEmployee(employee);
			System.out.println("Emplyee added successfully.");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
				
	}
	
	public static void updateEmployeeOp(Scanner sc) {
		
		
		//code to take input
		System.out.print("Enter employee id: ");
		String eid = sc.next();
		
		System.out.print("Enter employee name: ");
		String name = sc.next();
		
		System.out.print("Enter employee salary: ");
		double salary = sc.nextDouble();
		
		System.out.print("Enter joining date: ");
		LocalDate joiningDate = LocalDate.parse(sc.next());
		
		Employee employee = new EmployeeImpl(eid, name, salary, joiningDate);
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		try {
			empDAO.updateEmployee(employee);
			System.out.println("Emplyee updated successfully.");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
				
	}
	
    public static void deleteEmployeeOp(Scanner sc) {
		
		
		//code to take input
		System.out.print("Enter employee id: ");
		String eid = sc.next();
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		try {
			empDAO.deleteEmployee(eid);
			System.out.println("Emplyee updated successfully.");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
				
	}
    
    public static void viewEmployeeOp(Scanner sc) {
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		try {
			List<Employee> empList = empDAO.viewEmployeeList();
			Consumer<Employee> con = emp -> System.out.println("Employee Id "
					+ emp.getEid() + " Name: " +emp.getName() + "Salary " +
					emp.getSalary() + "JoiningDate: " + emp.getJoining_date());
			
			empList.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
		}
				
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Search Employee By Joining Date Range");
			System.out.println("0. Exit");
			System.out.println("Enter the Selection: ");
			choice = sc.nextInt();
			
			switch(choice) {
			   
			case 1: 
				//call to addEmployeeMethod
				addEmployeeOp(sc);
				break;
			case 2:
				//call to viewEmployeeMethod
				viewEmployeeOp(sc);
				break;
			case 3:
				//call to updateEmployeeMethod
				updateEmployeeOp(sc);
				break;
			case 4:
				//call to deleteEmployeeMethod
				//deleteEmployee(sc);
				break;
			case 5:
				//call to searchEmployeeByJoiningDateRange Method
				//searchEmployeeByDate(sc);
				break;
			case 0:
				System.out.println("Bye Bye");
				break;
			default:
				System.out.println("Invalid Selection please try again later");
				break;
			}
			
		}while(choice != 0);
		
		sc.close();
	}
}
