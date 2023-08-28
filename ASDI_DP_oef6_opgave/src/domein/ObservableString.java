package domein;

import java.util.Set;
import java.util.*;

public class ObservableString implements Subject 
{
    private String theString;
    private final Soort soort;
    
    private Set<Observer> obs;
    
    public ObservableString(Soort soort) {   
    	obs = new HashSet<>();
    	setTheString("");
        this.soort = soort;
    }

    public String getTheString() {
        return theString;
    }

    public void setTheString(String theString) {
        this.theString = theString;
        notifyObservers();
    }


	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.obs.add(obs);
	}

	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.obs.remove(obs);
	}
	
	private void notifyObservers() {
		obs.forEach(obs->obs.update(soort));
	}
}
