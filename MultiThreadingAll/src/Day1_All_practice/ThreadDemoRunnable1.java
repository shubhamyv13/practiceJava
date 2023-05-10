package Day1_All_practice;

public class ThreadDemoRunnable1 implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<40; i++) {
			System.out.println("Inside run() of the ThreadDemoRunnable. " + i);
		}
	}
	
	
	public static void main(String[] args) {
		
		//In this main block everything will be done by the main thread
		// things like t1s.start() , here t1s is also a thread but t1s.start() is executed by the main thread
		//and t1s is the calling object for the start() method because without it, the start() method won't 
		//be able to call the start().
		
		ThreadDemoRunnable1 t1 = new ThreadDemoRunnable1();
		
		Thread t1s = new Thread(t1, "Dhoni");
		
		t1s.start();
		
		for(int i=20; i<40; i++) {
			System.out.println("Inside main of ThreadDemoRunnable1: " + i);
		}

	}
	
}
