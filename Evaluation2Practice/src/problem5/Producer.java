package problem5;

public class Producer extends Thread{

	ConPro cp;
	
	public Producer(ConPro cp) {
		this.cp = cp;
	}
	
	@Override
	public void run() {
		
		int i =0;
		while(true) {
			cp.produce(i);
			i++;
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}
}
