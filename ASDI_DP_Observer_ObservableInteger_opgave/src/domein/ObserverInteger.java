package domein;

import java.util.HashSet;
import java.util.Set;

public class ObserverInteger implements Subject {

	
	private int value=1;
	private Set<Observer> observers = new HashSet<>();
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		notifyObservers();
	}


	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
		
	}
	

	private void notifyObservers() {
		observers.forEach(obs -> obs.update(value));
	}

}
