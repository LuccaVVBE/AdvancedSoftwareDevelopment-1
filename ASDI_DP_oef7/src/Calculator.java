import java.util.function.BinaryOperator;

public class Calculator {

//	private Computation computation;

//	public int compute(int x, int y, Computation computation) {
	public int compute(BinaryOperator<Integer> computation, int x, int y) {
		return computation.apply(x, y);
	}

//	public void setComputation(Computation computation) {
//		this.computation= computation;
//	}
	//BiFunction(T,U,R) 
	//BinaryOperator(T)  ==  BiFunction(T, T, T)
	
	public static void main(String[] args) {
		new Calculator().run();
	}

private void run() {
	// TODO Auto-generated method stub
	BinaryOperator<Integer> mul = (x,y)->x*y;
	
	System.out.println(compute((x,y)->x+y, 4, 5));
	System.out.println(compute(mul, 4,5));
}
}
