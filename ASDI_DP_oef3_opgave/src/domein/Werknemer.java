package domein;

public class Werknemer {
    
    private final String voornaam;
    private final String familienaam;
    private final String geboorteDatum;

    private Statuut statuut;

	public Werknemer(String voornaam, String familienaam, String geboorteDatum, Statuut s) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.geboorteDatum = geboorteDatum;
        setStatuut(s);
    }
    
    public void setStatuut(Statuut s) {
		// TODO Auto-generated method stub
		statuut = s;
	}

	public double geefJaarInkomst() {
		return statuut.geefJaarInkomst();
	}
}
