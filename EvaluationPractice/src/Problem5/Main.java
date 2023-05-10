package Problem5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public void printNonStatic(Student st) {
		System.out.println("Roll: " + st.getRoll());
		System.out.println("Name: " + st.getName());
		System.out.println("Address: " + st.getAddress());
		System.out.println("Dob: " + st.getDob());
	}
	
	public static void printStatic(Student st) {
		System.out.println("Roll: " + st.getRoll());
		System.out.println("Name: " + st.getName());
		System.out.println("Address: " + st.getAddress());
		System.out.println("Dob: " + st.getDob());
	}
	
	public Main(Student st) {
		
		System.out.println("Roll: " + st.getRoll());
		System.out.println("Name: " + st.getName());
		System.out.println("Address: " + st.getAddress());
		System.out.println("Dob: " + st.getDob());
	}
	
	public Main() {};

	public static void main(String[] args) {
		
		Student std = new Student(1, "Shubham", "Lko", LocalDate.parse("1998-10-25"));
		
		StudentService sNonStatic = new Main()::printNonStatic;
		
		sNonStatic.printStudentDetails(std);
		
		
		Student std1 = new Student(2, "Jagdeep", "Singapore", LocalDate.parse("1988-01-11"));
		
		StudentService sStatic = Main::printStatic;
		
		sStatic.printStudentDetails(std1);
		
		Student std2 = new Student(3, "Pardeep", "Mumbai", LocalDate.parse("1992-02-11"));	
		
		StudentService sConst = Main::new;
		
		sConst.printStudentDetails(std2);
		
		
	}
}
