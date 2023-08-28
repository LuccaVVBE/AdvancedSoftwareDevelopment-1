package domein;

public interface Subject {

	void addObserver(Observer obs);

	void removeObserver(Observer obs);
}
