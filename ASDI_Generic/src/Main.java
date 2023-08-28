import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		new Main().run();

	}

	private void run() {
		// TODO Auto-generated method stub
		//type erasure    // type enkel op source niveau
		List<Integer> li = new ArrayList<>();
		System.out.println(li.getClass().getName());
		li.add(123);
		//li.add("Jan"); Foutmelding => OK
		
		MyArray<String> myArray = new MyArray<>(10);
		myArray.set(5, "bop");
		//myArray.set(5, 123); FOUT => ok
		
		
		
		//upperbound
		List<String> li2 = new ArrayList<>(List.of("jan","piet","corneel")); 
		System.out.println(li2);
		foo(li2);
		System.out.println(li2);
		
		List<Brok> li3= new ArrayList<>(List.of(new Brok("jan"),new Brok("piet"),new Brok("corneel")));
		//System.out.println(li3); toont geheugenlocaties
		//foo(li3); // krijgt fout indien comparable niet geïmplementeerd is in Brok klasse.

		// Wildcard --> Compactere notatie voor generieke methoden, niet in alle gevallen mogelijk.
		foo2(li2);
		System.out.println(li2);
		
		//Raw
	}
	private <T extends Comparable<T>> void foo(List<T> lijst) { //generieke sorteermethode
		//verplicht om een comparable op het generieke type te hebben.
		lijst.sort(null);
	}
	
	private void foo2(List<? extends Comparable> lijst) { //generieke sorteermethode, met een wildcard
		//verpliocht om een comparable op het generieke type te hebben.
		lijst.sort(null);
	}

}
