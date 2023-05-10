package com.masaischool.sprint1;

@FunctionalInterface
public interface Intr1 {

	void sayHello(String name);
	boolean equals(Object o);
	
	private void funZero()
	{	
		System.out.println("Inside private funZero");
	}
	default void funone() {
		System.out.println("Inside default funOne");
		funZero();
	}
	
	static void funTwo() {
		System.out.println("Inside static funTwo");
	}
}
