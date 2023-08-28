package domein;

import static org.mockito.ArgumentMatchers.anyBoolean;

import persistentie.PersistentieController;

public class ContinentService {  //4 1 3 2
	private static final int PER_1000_INWONERS = 1000;
	private PersistentieController persistentieController; //STAP1
	public ContinentService() {  //STAP2
		this(new PersistentieController());
	}
	
	public ContinentService(PersistentieController pc) {  //STAP3
		persistentieController=pc;
	}
	public double geefGeboorteOverschot(String continent) {
		if (continent == null || continent.isBlank()) {
			throw new IllegalArgumentException("continent moet ingevuld zijn");
		}
		//PersistentieController persistentieController = new PersistentieController(); STAP4
		long aantalInwoners = persistentieController.findAantalBewoners(continent);
		if (aantalInwoners <= 0) {
			throw new IllegalArgumentException("geen inwoners gevonden voor gegeven continent");
		}

		long aantalSterfgevallen = persistentieController.findSterfteCijfer(continent);
		long aantalGeboorten = persistentieController.findGeboortecijfers(continent);
		if ( aantalSterfgevallen <0 || aantalGeboorten <0) {
			throw new IllegalArgumentException("negatief aantal");
		}
		double geboortecijfer = (double) aantalGeboorten / aantalInwoners * PER_1000_INWONERS;
		double sterftecijfer = (double) aantalSterfgevallen / aantalInwoners * PER_1000_INWONERS;

		return geboortecijfer - sterftecijfer;
	}
}
