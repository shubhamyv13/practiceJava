package daoLayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTOLayer.Employee;
import DTOLayer.EmployeeImpl;
import ExceptionLayer.NoRecordFoundException;
import ExceptionLayer.SomethingWentWrongException;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee emp) throws SomethingWentWrongException {
		
		Connection conn = null;
		
		try {
			conn = dbUtils.getConnectionTodatabase();
			
			String INSERT_QUERY = "INSERT INTO employee "
					+ "(eid, name, salary, joining_date)"
					+ "VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);
			
			ps.setString(1, emp.getEid());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setDate(4, Date.valueOf(emp.getJoining_date()));
			
			ps.executeUpdate();
			
			
		}catch(ClassNotFoundException | SQLException ex) {
			
		}finally {
				 try {
					 dbUtils.closeConnection(conn);
				 }catch(SQLException ex) {
					 
				 }
		}
		
	}
	
	public void updateEmployee(Employee emp) throws SomethingWentWrongException{
		
    Connection conn = null;
		
		try {
			conn = dbUtils.getConnectionTodatabase();
			
			String UPDATE_QUERY = "UPDATE employee SET"
					+ "name=?, salary=?, joining_date=?)"
					+ "WHERE eid =? ";
			
			PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);
			
			ps.setString(4, emp.getEid());
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setDate(3, Date.valueOf(emp.getJoining_date()));
			
			ps.executeUpdate();
			
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to update the recrod now, try again later");
		}finally {
				 try {
					 dbUtils.closeConnection(conn);
				 }catch(SQLException ex) {
					 
				 }
		}
	}
	
	public void deleteEmployee(String empId) throws SomethingWentWrongException{
		
	    Connection conn = null;
			
			try {
				conn = dbUtils.getConnectionTodatabase();
				
				String DELETE_QUERY = "DELETE FROM employee"
									+ "WHERE eid =? ";
				
				PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);
				
				ps.setString(4, empId);
				
				ps.executeUpdate();
				
				
			}catch(ClassNotFoundException | SQLException ex) {
				throw new SomethingWentWrongException("Unable to delete the recrod now, try again later");
			}finally {
					 try {
						 dbUtils.closeConnection(conn);
					 }catch(SQLException ex) {
						 
					 }
			}
	}
	
    public List<Employee> viewEmployeeList() throws SomethingWentWrongException, NoRecordFoundException{
		
	    Connection conn = null;
	    List<Employee> list = new ArrayList<>();
			
			try {
				conn = dbUtils.getConnectionTodatabase();
				
				String SELECT_QUERY = "SELECT eid, name, salary"
						+ " joining_date FROM employee";
				
				PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
				
				ResultSet rs = ps.executeQuery();
				if(dbUtils.checkEmpty(rs)) {
					throw new NoRecordFoundException("No Record found.");
				}
				
				while(rs.next()) {
					
					list.add(new EmployeeImpl(rs.getString(1),
							         rs.getString(2),
							         rs.getDouble(3),
							         rs.getDate(4).toLocalDate()));
				}
				
				
			}catch(ClassNotFoundException | SQLException ex) {
				throw new SomethingWentWrongException("Unable to update the recrod now, try again later");
			}finally {
					 try {
						 dbUtils.closeConnection(conn);
					 }catch(SQLException ex) {
						 
					 }
			}
			return list;
	}
	
}
