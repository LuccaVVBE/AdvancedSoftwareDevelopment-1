package domein;

import java.util.HashSet;
import java.util.Set;

public class ObservableInteger implements Subject {

    private int value = 1;
	private Set<Observer> observers = new HashSet<>();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }

    public void add(int number) {
        setValue(value + number);
    }

    public void subtract(int number) {
        setValue(value - number);
    }

    public int getDoubleValue() {
        return value * 2;
    }

		@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.add(obs);
		obs.update(value);
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
