package problem5;

public class Main {

	public static void main(String[] args) {
		
		ConPro cp = new ConPro();
		
		Producer p = new Producer(cp);
		Consumer c = new Consumer(cp);
		
		p.start();
		c.start();
	}
}
