package domein;

public class Arbeider implements Statuut{
    
    private double uurloon;
    private int ploegenstelsel;

    public Arbeider(double uurloon, int ploegenstelsel) {
        
        this.uurloon = uurloon;
        this.ploegenstelsel = ploegenstelsel;
    }

    @Override
    public double geefJaarInkomst() {
        return uurloon * ploegenstelsel;
    }

	public Arbeider(String voornaam, String familienaam, String geboorteDatum, double uurloon, int ploegenstelsel) {
		throw new UnsupportedOperationException();
	}
    
    
}
