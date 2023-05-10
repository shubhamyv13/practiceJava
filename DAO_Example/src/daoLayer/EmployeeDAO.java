package daoLayer;

import java.util.List;

import DTOLayer.Employee;
import DTOLayer.EmployeeImpl;
import ExceptionLayer.NoRecordFoundException;
import ExceptionLayer.SomethingWentWrongException;

public interface EmployeeDAO {

	public void addEmployee(Employee emp) throws SomethingWentWrongException;
	public void updateEmployee(Employee emp) throws SomethingWentWrongException;
	public void deleteEmployee(String empId) throws SomethingWentWrongException;
	public List<Employee> viewEmployeeList() throws SomethingWentWrongException, NoRecordFoundException;

}
