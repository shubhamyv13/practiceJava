package Day2_practice;

public class WaitNotify extends Thread{

	public void run() {
		
		synchronized(this) {
			try {
				this.wait();
				System.out.println(Thread.currentThread().getName());
				System.out.println(2);
				this.notify();
				this.wait();
				System.out.println(4);
				this.notify();
			}catch(InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		WaitNotify wn = new WaitNotify();
		
		wn.start();
		synchronized(wn) {
			System.out.println(1);
		    wn.notify();
		    
		    wn.wait();
		    wn.sleep(1000);
		}
		
		try {
			wn.join();
		}catch(InterruptedException ex) {
			System.out.println(ex);
		}
	}
	
	
	
}
