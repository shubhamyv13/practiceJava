package Problem1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		
		Predicate<Product> pred = product -> product.getQuantity() < 5;
		
		System.out.println(pred.test(new Product(6,"Tea", 100,4)));
		System.out.println(pred.test(new Product(7,"Salt", 20,10)));
		
		Consumer<Product> cons = product -> {
			
			System.out.println("ProductId: " + product.getProdId());
			System.out.println("ProductName: " + product.getProdName());
			System.out.println("ProductPrice: "+ product.getPrice());
			System.out.println("ProductQuantity: " + product.getQuantity());
		};
		
		cons.accept(new Product(8, "Groundnuts",120, 2));
		
		Supplier<Product> sup = () -> new Product(9, "Fruits", 200, 6);
		
		System.out.println(sup.get());
		
		Function<String, Product> fun = s ->{
			
			String[] str = s.split(",");
			
			return new Product(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]));
			
		};
		
		System.out.println(fun.apply("10,Foxnut,150,3"));
	}
}
