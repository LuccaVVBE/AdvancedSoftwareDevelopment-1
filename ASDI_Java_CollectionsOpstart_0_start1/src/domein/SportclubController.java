package domein;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SportclubController {

	private SporterBeheerder sporterBeheerder;

	public SportclubController() {
		sporterBeheerder = new SporterBeheerder();
	}
//TODO uncomment OEF GENERICS
	public String geefSportersPerLidnr() {
		return sporterBeheerder.geefSportersPerLidnr();
	}

	public String geefSportersPerAantalReductiebonnen() {
		return sporterBeheerder.geefSportersPerAantalReductiebonnen();
	}


	public String geefSporters() {
		return geefGesorteerdCollectie(sporterBeheerder.getSportersLijst());
	}
	
	public <T extends Comparable<T>> String geefGesorteerdCollectie(Collection<T> coll) {
		
		
		
		return coll.stream().sorted().map(T::toString).collect(Collectors.joining("\n"));
		
	}
	
	public String geefSportersMetEvenveelReductiebonnen(int lidnr) {
		Sporter sporter = sporterBeheerder.geefSporter(lidnr);
		if(sporter == null) {
			return "Ongekend lidnr";
		}
		List<Sporter> sporters = sporterBeheerder.geefSportersMetEvenveelReductiebonnen(sporter);
		if(sporters.size() == 1) {
			return "geen sporters met evenveel reductiebonnen";
		}
		return sporters.stream().map(s -> s.getNaam()).collect(Collectors.joining(" - "));
	}

	//TODO OEF GENERICS...
}
