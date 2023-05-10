package com.masaischool.FunctionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args){
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1, "Shubham", 700));
		list .add(new Student(2,"Tejasvi", 100));
		list.add(new Student(5, "Shailesh", 400));
		list .add(new Student(6,"Jagdeep", 500));
		list.add(new Student(3, "Akhilesh", 200));
		list .add(new Student(4,"Sanju", 300));
		
		System.out.println(list);
		
		//Comparator implementation using the conventional way
		
		ComparatorImpl cmp = new ComparatorImpl();
		
		Collections.sort(list, cmp);
		
		System.out.println(list);
		System.out.println("-=-=-=--=--=-=-=-=-=-=-=-=-=-=-=-");
		
		//Comparator implementation using the anonymous class
		
		Comparator<Student>  cmpr = new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				
				if(o1.getMarks() < o2.getMarks()) return 1;
				else if(o1.getMarks() > o2.getMarks()) return -1;
				else return 0;
			}
		};
		
		Collections.sort(list, cmpr);
		
		System.out.println(list);
		System.out.println("-=-=-=--=--=-=-=-=-=-=-=-=-=-=-=-");
		
		//Comparator implementation using the Lambda expression
		
		Comparator<Student> cmprL = (Student o1, Student o2) -> {
			
			if(o1.getMarks() > o2.getMarks()) return 1;
			else if(o1.getMarks() < o2.getMarks()) return -1;
			else return 0;
		};
		
		Collections.sort(list,cmprL);
		
		System.out.println(list);
		System.out.println("-=-=-=--=--=-=-=-=-=-=-=-=-=-=-=-");
		
		//Direct passing of Comparator implementation using lambda expression to Collecitons() method
		
		Collections.sort(list, (Student o1, Student o2) -> {
			
			if(o1.getMarks() < o2.getMarks()) return 1;
			else if(o1.getMarks() > o2.getMarks()) return -1;
			else return 0;
			
		});
		
		System.out.println(list);
		System.out.println("-=-=-=--=--=-=-=-=-=-=-=-=-=-=-=-");
		
		//Comparator implementation using the Method reference 
		
		
		
	}
}
