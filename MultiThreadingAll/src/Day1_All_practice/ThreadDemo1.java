package Day1_All_practice;

public class ThreadDemo1 extends Thread {
	
	public ThreadDemo1() {}
	
	public ThreadDemo1(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("Inside run method of ThreadDemo1");
		
		for(int i=0; i<30; i++) {
			System.out.print(i + " ");
			
		}
		System.out.println();
		System.out.println("End of run() method of ThreadDemo1");
	}
	
	public static void main(String[] args) {
		
		ThreadDemo1 t1 = new ThreadDemo1("Shubham");
		
		//Now if I call the run() directly with the t1, then the method will be executed by the main thread
		//t1.run()
		
		//But if I do t1.start() then the t1 thread will be put on the list of the thread scheduler to run 
		
		t1.start();
		
		System.out.println("Inside main method of ThreadDemo1");
		for(int i=30; i<60; i++ ) {
			System.out.print(i + " ");
		}
	}
}
