package domein;

import java.util.stream.Collectors;

public class DomeinController {

    private final BierWinkel bierWinkel;

    public DomeinController() {
        bierWinkel = new BierWinkel();
    }
	public String opzettenBierPerNaam() {
		// TODO
		return bierWinkel.opzettenOverzichtBierPerNaam().values().stream().map(Bier::toString).collect(Collectors.joining("\n"));
		
	}
    public String opzettenAantalBierenPerSoort() {
    	//TODO
    	return bierWinkel.opzettenAantalBierenPerSoort().entrySet().stream().map(entry->String.format("%s - %s%n", entry.getKey(), entry.getValue()))
    			.collect(Collectors.joining());
    }

    public String opzettenOverzichtBierenPerSoort() {
    	//TODO
    	return bierWinkel.opzettenOverzichtBierenPerSoort().entrySet().stream().map(entry->String.format("%s - %s%n",entry.getKey(), entry.getValue()))
    			.collect(Collectors.joining());
    }


    //TODO na hoofdstuk generics 
    //--> generieke oplossing "overzichtToString" methode
    //


}
