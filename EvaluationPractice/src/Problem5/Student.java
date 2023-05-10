package Problem5;

import java.time.LocalDate;

public class Student {

	private int roll;
	private String name;
	private String address;
	private LocalDate dob;
	
	public Student() {}
	
	public Student(int roll, String name, String address, LocalDate dob) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
		this.dob = dob;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Roll= " + roll + ", Name= " + name + ", Address= " + address + ", Dob= " + dob + "\n";
	}
	
	
	
}
