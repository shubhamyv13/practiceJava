package UILayer;

import java.util.Scanner;

public class UIMain {
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. View Student List");
			System.out.println("5. Search Student By Name");
			System.out.println("0. Exit");
			
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					adminLogin(sc);
					break;
				case 2:
					customerLogin(sc);
					break;
				case 3:
					deleteStudent(sc);
					break;
				case 4:
					printStudentList();
					break;
				case 0:
					System.out.println("Thnaks for using our services");
					break;
				default:
					System.out.println("Invalid Selection, try again later");
			}			
		}while(choice != 0);
		
		sc.close();
	}
}
