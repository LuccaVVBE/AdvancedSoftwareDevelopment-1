package domain;

import java.util.HashSet;
import java.util.Set;

public class Account implements Subject{

    // Account balance
    private double balance;

    private Set<Observer> observers;
    
    // readonly Account name
    private String name;

    
    // Account constructor
    public Account(String accountName, double openingDeposit) {
        
        name = accountName;
        observers = new HashSet<>();
        setBalance(openingDeposit);
        
    }

    // set Account balance and notify observers of change
    private void setBalance(double accountBalance) {
        balance = accountBalance;
        notifyObservers();
    }



	// get Account balance
    public double getBalance() {
        return balance;
    }

    // withdraw funds from Account
    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Cannot withdraw negative amount");
        }

        // update Account balance
        setBalance(getBalance() - amount);
    }

    // deposit funds in account
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }

        // update Account balance
        setBalance(getBalance() + amount);
    }

    // get Account name (readonly)
    public String getName() {
        return name;
    }

    //Bij observers altijd deze 3 methodes!
	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.add(obs);
		obs.update(balance);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
		
	}
	
    private void notifyObservers() {
		// TODO Auto-generated method stub
    	observers.forEach(obs -> obs.update(balance));
		
	}
}
