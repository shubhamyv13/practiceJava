package Problem3;

import java.util.ArrayList;
import java.util.Collections;
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
		list.add(new Student(6,"Kuldeep", 800, "Lko"));
		list.add(new Student(7,"Akhilesh", 150, "Singapore"));
		list.add(new Student(8,"Kulbhushan", 390, "Mumbai"));
		list.add(new Student(9,"Amardeep", 590, "Gujrat"));
		list.add(new Student(510,"Sandeep", 900, "Gkp"));
		
		List<Student> filtList = list.stream()
				                     .filter(i -> i.getName().length() %2 ==0)
				                     .map(i -> new Student(i.getRoll(), i.getName().toUpperCase(),i.getMarks(),i.getAddress()))
				                     .collect(Collectors.toList());
		
        Collections.sort(filtList, (o1,o2) -> {
		
			if(o1.getName().compareTo(o2.getName()) < 0) return 1;
			else if(o1.getName().compareTo(o2.getName()) > 0) return -1;
			else return 0;
		});
        
        list.forEach(i -> System.out.println(i + " "));
        
        filtList.forEach(i -> System.out.println(i + " "));
		
	}
}
