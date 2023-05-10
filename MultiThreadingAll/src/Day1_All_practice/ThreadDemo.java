package Day1_All_practice;

public class ThreadDemo extends Thread {
	
	public ThreadDemo() {};
	
	public ThreadDemo(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		
		System.out.println("Inside the ThreadDemo.");
		String tname = Thread.currentThread().getName();
		System.out.println(tname);
	}

	public static void main(String[] args) {
		
		ThreadDemo t1 = new ThreadDemo("Shubham");
		System.out.println(t1.getPriority());
		t1.setPriority(MAX_PRIORITY);
		System.out.println(t1.getPriority());
		t1.start();
	}
}
