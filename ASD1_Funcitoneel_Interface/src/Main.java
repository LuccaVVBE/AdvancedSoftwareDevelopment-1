import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

	private void run() {
		// TODO Auto-generated method stub
		System.out.println("Functioneel intro");
		Function<String, String> fie = x -> x; // wat er meegegeven wordt, wordt teruggegeven.
		
		System.out.println(fie.apply("boodschap"));
		
		Consumer<String> cons = x->System.out.println(x);
		cons.accept("BOODSCHAP");
		
		Supplier<String> supp = ()-> "BoOdScHaP";
		System.out.println(supp.get());
		
		foo(supp);
		foo(()->1234);
	
	}
	private <T> void foo(Supplier<T> supp) {
		System.out.println(supp.get());
	}

}
