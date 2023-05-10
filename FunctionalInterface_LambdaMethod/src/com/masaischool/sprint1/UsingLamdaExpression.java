package com.masaischool.sprint1;

public class UsingLamdaExpression {

	public static void main(String[] args){
		
		//Implementation of Intr1 functional interface 
		//Using the Lambda expression
		
		//We are able to access Intr1 and implement it 
		//Because the Intr1 is in the same pacakage as of
		//This class
		
		
		Intr1 intrOne = (String name) -> {
			System.out.println("Hello! " + name);
		};
		
		intrOne.sayHello("Tejas");
	}
}
