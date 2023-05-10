package problem1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main implements Callable{
	
	private Student stud;
	
	public Main(Student stud) {
		this.stud = stud;
	}
	
	

	public Student getStud() {
		return stud;
	}



	public void setStud(Student stud) {
		this.stud = stud;
	}



	@Override
	public Boolean call() throws Exception {
		
		if(stud.getMarks() < 500) return false;
		else return true;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Main[] tasks = {
				new Main(new Student(1,"Shubham", "Lko", 450)),
				new Main(new Student(2,"Jagdeep", "Lko", 500)),
				new Main(new Student(3,"Pradeep", "Lko", 560)),
				new Main(new Student(4,"Chandeep", "Lko", 350)),
				new Main(new Student(5,"Abhishek", "Lko", 590)),
				new Main(new Student(6,"Akhilesh", "Lko", 600)),
		};
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(Main st : tasks) {
			Future f = service.submit(st);
			
			if((boolean)f.get() == false)
				System.out.println("Roll " + st.getStud().getRoll() 
						          + " student is Fail.");
			else System.out.println("Roll " + st.getStud().getRoll() 
						          + " student is Pass.");
		}
		
		service.shutdown();
	}

}
