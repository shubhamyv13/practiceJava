package com.masaischool.day2MethodReferenceSTATIC;

public class MethodReferenceDemo {

	@FunctionalInterface
	interface ConvertStringToNumber{
		int convertToInt(String value);
	}
	
	@FunctionalInterface
	interface ArrayOperations{
		int findMinimumElementFromArray(int arr[]);
	}
	
	static int getMinimum(int arr[]) {
		int min = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(min>arr[i]) min = arr[i];
		}
		return min;
	}
	
	
	public static void main(String[] args) {
		
//		Implementation using the Lambda expression
		
//	    ConvertStringToNumber c = value -> Integer.parseInt(value);
//	    System.out.println(c.convertToInt("10") + 1);
		
		ConvertStringToNumber c = Integer::parseInt;
		System.out.println(c.convertToInt("10") + 1);
		
		
		//getMinimum used in Method reference
		
		ArrayOperations a = MethodReferenceDemo::getMinimum;
		
		System.out.println(a.findMinimumElementFromArray(new int[] {10, 20, 1}));
	}
}
