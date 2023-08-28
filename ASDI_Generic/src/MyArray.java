
public class MyArray<T> {
	private T[] arr;
	
	public MyArray(int capacity) {
		//arr = new [capacity]; //CANNOT ... want T bestaat niet meer, is een effectief type
		//arr = new Object[capacity]; //Mismatch
		arr = (T[]) new Object[capacity];
	}
	public T get(int index) { //methode in generieke klasse
		return arr[index];
	}
	
	public void set(int index, T value) {
		arr[index] = value;
	}
}
