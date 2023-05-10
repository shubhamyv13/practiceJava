package com.masaischool.FunctionalInterface;

public class Student {

	private int rollNo;
	private String name;
	private int marks;
	
	public Student() {}
	
	public Student(int rollNo, String name, int marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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

	@Override
	public String toString() {
		return "RollNo= " + rollNo + ", Name= " + name + ", Marks= " + marks + "\n";
	}
	
	
	
	
}
