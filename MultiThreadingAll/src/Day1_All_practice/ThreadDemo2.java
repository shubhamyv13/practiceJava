package Day1_All_practice;

public class ThreadDemo2 extends Thread {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Inside run method of ThreadDemo2 " + i);
		}
		System.out.println("End of ThreadDemo2");
	}
	
	public static void main(String[] args) {
		
		ThreadDemo2 t1 = new ThreadDemo2();
		ThreadDemo1 t2 = new ThreadDemo1();
		ThreadDemo t3 = new ThreadDemo();
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}


