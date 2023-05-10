package jdbcExample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EmployeeCRUDOperations {

	/**
	 * Establish connection to the database
	 * @return Connection object that is handle for the connection with database
	 * @throws SQLException If some credentials are wrong, database not started etc ect
	 * @throws ClassNotFoundException If driver class is not found
	 */
	static Connection getConnectionTodatabase() throws SQLException, ClassNotFoundException {
		//step-1: load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		//step-2
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		return DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
	}
	
	/**
	 * close the connection with the database
	 * @param conn Connection object for which connection is to be closed
	 * @throws SQLException if anything goes wrong
	 */
	static void closeConnection(Connection conn) throws SQLException {
		if(conn != null)
			conn.close();
	}
	
	static void addEmployee(Scanner sc) {
		//step 01 - Make Connection with Database
		Connection conn = null;
		
		try {
			conn = getConnectionTodatabase();
			
			//Step 02 - Frame Query
			
			String INSER_QUERY = "INSERT INTO employee"
					+ " (eid, name, salary, joining_date) VALUES"
					+ " (?,?,?,?)";
			
            //Step 03 - take an object of PreparedStatement
			
			PreparedStatement ps = conn.prepareStatement(INSER_QUERY);
			
			//Step 04 - Take data input
			
			System.out.print("Enter employee id: ");
			String eid = sc.next();
			
			System.out.print("Enter employee name: ");
			String name = sc.next();
			
			System.out.print("Enter employee salary: ");
			double salary = sc.nextDouble();
			
			System.out.print("Enter joining date: ");
			LocalDate joiningDate = LocalDate.parse(sc.next());
			
			//Step 05 - bind these data taken from user to the placeholder
			
			ps.setString(1, eid);
			ps.setString(2, name);
			ps.setDouble(3, salary);
			ps.setDate(4, Date.valueOf(joiningDate));
			
			//Step 06 - execute the insert operation
			if(ps.executeUpdate() > 0) {
				System.out.println("Employee added Successfully.");
			}else {
				System.out.println("Some error came.");
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			System.err.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
		
		
	}
	
	static void updateEmployee(Scanner sc) {
		//step 01 - Make Connection with Database
		Connection conn = null;
		
		try {
			conn = getConnectionTodatabase();
			
			//Step 02 - Frame Query
			
			String UPDATE_QUERY = "UPDATE employee SET"
					+ " name = ?, salary = ?, joining_date = ?"
					+ " WHERE eid = ?";
			
            //Step 03 - take an object of PreparedStatement
			
			PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);
			
			//Step 04 - Take data input
			
			System.out.print("Enter employee id: ");
			String eid = sc.next();
			
			System.out.print("Enter employee name: ");
			String name = sc.next();
			
			System.out.print("Enter employee salary: ");
			double salary = sc.nextDouble();
			
			System.out.print("Enter joining date: ");
			LocalDate joiningDate = LocalDate.parse(sc.next());
			
			//Step 05 - bind these data taken from user to the placeholder
			
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setDate(3, Date.valueOf(joiningDate));
			ps.setString(4, eid);
			
			//Step 06 - execute the insert operation
			if(ps.executeUpdate() > 0) {
				System.out.println("Data Updated Successfully.");
			}else {
				System.out.println("Some error came.");
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			System.err.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
		
		
	}
	
	static void deleteEmployee(Scanner sc) {
		//step 01 - Make Connection with Database
		Connection conn = null;
		
		try {
			conn = getConnectionTodatabase();
			
			//Step 02 - Frame Query
			
			String DELETE_QUERY = "DELETE FROM employee"
					+ " WHERE eid = ?";
			
            //Step 03 - take an object of PreparedStatement
			
			PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);
			
			//Step 04 - Take data input
			
			System.out.print("Enter employee id: ");
			String eid = sc.next();
			
			//Step 05 - bind these data taken from user to the placeholder
		
			ps.setString(1, eid);
			
			//Step 06 - execute the insert operation
			if(ps.executeUpdate() > 0) {
				System.out.println("Employee deleted Successfully.");
			}else {
				System.out.println("Some error came.");
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			System.err.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
		
		
	}
	
	static void searchEmployeeByDate(Scanner sc) {
		//step 01 - Make Connection with Database
		Connection conn = null;
		
		try {
			conn = getConnectionTodatabase();
			
			//Step 02 - Frame Query
			
			String VIEW_QUERY = "SELECT eid, name, salary, joining_date"
					+ " FROM employee WHERE joining_date BETWEEN ? AND ?";
			
            //Step 03 - take an object of PreparedStatement
			
			PreparedStatement ps = conn.prepareStatement(VIEW_QUERY);
			
           //Step 04 - Take data input
			
			System.out.print("Please enter start date: ");
			Date startDate = Date.valueOf(LocalDate.parse(sc.next()));
			System.out.print("Please enter start date: ");
			Date endDate = Date.valueOf(LocalDate.parse(sc.next()));
			
			//Step 05 - bind these data taken from user to the placeholder
		
			ps.setDate(1, startDate);
			ps.setDate(2, endDate);
			
			//Step 06 - execute the insert operation
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst() && rs.getRow() == 0){
				System.out.println("No Employee Found");
			}else {
				while(rs.next()) {
					System.out.print("Employee id: " + rs.getString(1));
					System.out.print("Employee name: " + rs.getString(2));
					System.out.print("Salary: " + rs.getDouble(3));
					System.out.print("Joining Date: " + rs.getDate(4));
				}
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			System.err.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
	}
	
	static void viewEmployee() {
		//step 01 - Make Connection with Database
		Connection conn = null;
		
		try {
			conn = getConnectionTodatabase();
			
			//Step 02 - Frame Query
			
			String VIEW_QUERY = "SELECT eid, name, salary, joining_date"
					+ " FROM employee";
			
            //Step 03 - take an object of PreparedStatement
			
			PreparedStatement ps = conn.prepareStatement(VIEW_QUERY);
			
			//Step 04 - execute the insert operation
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst() && rs.getRow() == 0){
				System.out.println("No Employee Found");
			}else {
				while(rs.next()) {
					System.out.print("Employee id: " + rs.getString(1));
					System.out.print("Employee name: " + rs.getString(2));
					System.out.print("Salary: " + rs.getDouble(3));
					System.out.print("Joining Date: " + rs.getDate(4));
				}
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			System.err.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
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
				addEmployee(sc);
				break;
			case 2:
				//call to viewEmployeeMethod
				viewEmployee();
				break;
			case 3:
				//call to updateEmployeeMethod
				updateEmployee(sc);
				break;
			case 4:
				//call to deleteEmployeeMethod
				deleteEmployee(sc);
				break;
			case 5:
				//call to searchEmployeeByJoiningDateRange Method
				searchEmployeeByDate(sc);
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
