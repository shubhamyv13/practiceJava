package DTOLayer;

import java.time.LocalDate;

public interface Employee {

	public String getEid();

	public void setEid(String eid);

	public String getName();

	public void setName(String name);

	public double getSalary();
	
	public void setSalary(double salary);

	public LocalDate getJoining_date();

	public void setJoining_date(LocalDate joining_date);	
}
