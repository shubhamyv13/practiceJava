package problem5;

public class ConPro {
   
	static boolean flag = true;
	int num;
	
	public synchronized void produce(int i) {
		
		if(flag == true) {
			num = i;
			this.notify();
			System.out.println("Producer produced : " + num);
			flag = false;
			try {
				this.wait();
			}catch(InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}
	
    public synchronized int consume() {
    	int sum = 0;
		if(flag == true) {
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			
			flag = true;
			this.notify();
			for(int i=0; i<=num; i++) {
				sum+= i;
			}
			return sum;
   }
}
