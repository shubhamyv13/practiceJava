package problem5;

public class Consumer extends Thread{

	ConPro cp ;
	
	public Consumer(ConPro cp) {
		this.cp = cp;
	}
	
	@Override
	public void run() {
		
		while(true) {
			int i = cp.consume();
			System.out.println("Consumer Caculated Sum is: " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
