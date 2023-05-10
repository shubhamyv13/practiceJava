package com.masaischool.sprint1;

public class UsingAnnonymousInnerClass{

	
	public static void main(String[] args) {
		
		//Anonymous class implementation of Intr1
		
		Intr1 intrOne = new Intr1(){
			
			
			@Override
			public void sayHello(String name) {
				System.out.println("Hello " + name + "!" );
			}
		};
		
		intrOne.sayHello("Shubham");
		intrOne.funone();
		Intr1.funTwo();
		
		
		
		
		//Anonymous class implementation of Intr2
       Intr2 intrTwo = new Intr2(){
			
			
			@Override
			public void sayHello(String name) {
				System.out.println("Hello " + name + "!" );
			}
		};
		
		intrTwo.sayHello("Shubham");
		intrTwo.funone();
		
		//As funTwo() is static method of Intr1, We cannot call
		// is as
		// Intr2.funTwo();   <--Error
		Intr1.funTwo();
		
		
		//Anonymous class implementation of Intr3
		
		Intr3 intrThree = new Intr3() {

			@Override
			public void difference(int a, int b) {
				
				System.out.println(a-b);
				
			}

			@Override
			public void add(int a, int b) {
				
				System.out.println(a + b);
				
			}
			
		};
		
		intrThree.difference(5, 2);
		intrThree.add(2, 3);
		
	}
}
