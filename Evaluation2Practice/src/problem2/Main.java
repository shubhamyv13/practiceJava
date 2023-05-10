package problem2;

public class Main {

	public static void sum() {
		int sum =0;
		for(int i=1; i<=20; i++) {
			sum+= i;
		}
		System.out.println(Thread.currentThread().getName() + " Prints " + sum);
	}
	
    public static void print() {
		
    	System.out.print(Thread.currentThread().getName() + " Prints 1-10: ");
		for(int i=1; i<=10; i++) {
			System.out.print(i + " ");
		}	
	}
    
    public static void prod() {
		System.out.println();
		int pro =1;
		for(int i=1; i<=10; i++) {
			pro*= i;
		}
		System.out.println(Thread.currentThread().getName() + " Prints " + pro);
	}
    
    
    public static void main(String[] args) {
    	
    	Runnable sum = Main::sum;
    	Runnable pro = Main::prod;
    	Runnable print = Main::print;
    	
    	Thread t1 = new Thread(sum, "Virat");
    	Thread t2 = new Thread(print, "Dhoni");
    	Thread t3 = new Thread(pro, "Rohit");
    	
    	t2.setPriority(Thread.MAX_PRIORITY);
    	
    	t2.start();
    	try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	t3.start();
    	try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	t1.start();
    	try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
