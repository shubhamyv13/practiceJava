package Problem2;

public class Student {

	private int roll;
	private String name;
	private int marks;
	private String address;
	
	public Student() {}
	
	public Student(int roll, String name, int marks, String address) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		this.address = address;
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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Roll= " + roll + ", Name= " + name + ", Marks= " + marks + ", Address=" + address + "\n";
	}
	
}
