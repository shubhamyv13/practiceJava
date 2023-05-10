package Problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1,"Shubham", 200, "Lko"));
		list.add(new Student(2,"Jagdeep", 300, "Singapore"));
		list.add(new Student(3,"Pradeep", 500, "Mumbai"));
		list.add(new Student(4,"Chandeep", 600, "Gujrat"));
		list.add(new Student(5,"Abhishek", 700, "Gkp"));
		
		List<Employee> emp = list.stream().filter(i -> i.getMarks() > 500)
				                          .map(i -> new Employee(i.getRoll(), i.getName(), i.getMarks()*10000, i.getAddress()))
				                          .collect(Collectors.toList());
		
		Comparator<Employee> cmp = (o1,o2) -> {
		   
			if((o1.getSalary()- o2.getSalary()) < 0) return 1;
			else if((o1.getSalary()- o2.getSalary()) > 0) return -1;
			else return 0;
		};
		
		Collections.sort(emp, cmp);
		
		list.forEach(i -> System.out.println(i +" "));
		System.out.println("-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=--==-=-");
		emp.forEach(i -> System.out.println(i +" "));
	}
}
