package DTOLayer;

import java.time.LocalDate;

public class EmployeeImpl implements Employee{

	private String eid;
	private String name;
	private double salary;
	private LocalDate joining_date;
	
	public EmployeeImpl() {}
	
	public EmployeeImpl(String eid, String name, double salary, LocalDate joining_date) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
		this.joining_date = joining_date;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(LocalDate joining_date) {
		this.joining_date = joining_date;
	}

	@Override
	public String toString() {
		return "Eid= " + eid + ", name= " + name + ", salary= " + salary + ", joining_date= " + joining_date
				+ "\n";
	}
	
	
}
