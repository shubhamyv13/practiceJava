package Problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Problem2.Student;

public class Main {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1,"Shubham", 200, "Lko"));
		list.add(new Student(2,"Jagdeep", 300, "Singapore"));
		list.add(new Student(3,"Pradeep", 500, "Mumbai"));
		list.add(new Student(4,"Chandeep", 600, "Gujrat"));
		list.add(new Student(5,"Abhishek", 700, "Gkp"));
		list.add(new Student(6,"Kuldeep", 800, "Naini"));
		list.add(new Student(7,"Akhilesh", 150, "Singapore"));
		list.add(new Student(8,"Kulbhushan", 390, "Mumbai"));
		list.add(new Student(9,"Amardeep", 590, "Gujrat"));
		list.add(new Student(510,"Sandeep", 900, "Gkp"));
		
		System.out.println(list.stream().anyMatch(i -> i.getName().length() > 9));
		System.out.println(list.stream().allMatch(i -> i.getName().length() > 2));
		System.out.println(list.stream().noneMatch(i -> i.getName().length() > 11));
		System.out.println(list.stream().count());
		
		List<Student> filtered = list.stream().filter(i -> i.getAddress().equals("Lko"))
				                              .collect(Collectors.toList());
		
		filtered.forEach(i -> System.out.println(i + " "));
		
	}
}
