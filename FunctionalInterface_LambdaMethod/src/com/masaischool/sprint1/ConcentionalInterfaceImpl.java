package com.masaischool.sprint1;

public class ConcentionalInterfaceImpl implements Intr2{

	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name + "!" );
	}
	
	
	public static void main(String[] args) {
		
		Intr1 intrOne = new ConcentionalInterfaceImpl();
		//Now sayHello() of the interface Intr1 can be
		//Implemented by many classes. So how does the 
		//Calling of the method takes place?
		//Which class' implementation will be taken?
		//Here comes the concept of Dynamic Method Dispatch
		//Means, the decision is taken at the runtime
		//When the object is made and to which object the 
		//Interace's reference variable is pointing
		intrOne.sayHello("Shubham");
		intrOne.funone();
		
		//Static methods of an interface can only be called 
		//using the Interface name only
		Intr1.funTwo();
		
		Intr2 interTwo = new ConcentionalInterfaceImpl();
		interTwo.sayHello("Yadav");
		System.out.println(interTwo.equals(interTwo));
	}
}
