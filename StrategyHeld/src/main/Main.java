package main;

import domein.Geweer;
import domein.Held;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();

	}
	
	private static void run() {
		Held held = new Held();
		held.valAan();
		
		held.setWapen(new Geweer());
		held.valAan();
	}

}
