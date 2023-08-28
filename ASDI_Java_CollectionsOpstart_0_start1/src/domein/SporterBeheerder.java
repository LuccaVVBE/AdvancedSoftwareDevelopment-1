package domein;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import repository.SporterDao;
import repository.SporterDaoJpa;

public class SporterBeheerder {

	private SporterDao sporterDao;
	private Collection<Sporter> sportersLijst;

	// TODO OEF MAP extra attributen
	Map<Integer, Sporter> sporterPerLidnummer;
	Map<Integer, List<Sporter>> sportersPerAantalReductieBonnen;

	public SporterBeheerder() {
		sporterDao = new SporterDaoJpa();
		sportersLijst = sporterDao.findAll();
		// TODO OEF MAP
		 maakOverzichten();
		
	}

	public Collection<Sporter> getSportersLijst() {
		return Collections.unmodifiableCollection(sportersLijst);
	}

	// TODO OEF MAP extra methoden
	public void maakOverzichten()
	{
		sporterPerLidnummer = sportersLijst.stream().collect(Collectors.toMap(Sporter::getLidNr, s->s));
		sportersPerAantalReductieBonnen = sportersLijst.stream().collect(Collectors.groupingBy(s->s.getReductiebonLijst().size()));
	}

	// VRAAG 6
	public Sporter geefEenSporterMetGegevenReductiebon(Reductiebon bon) {
		return sportersLijst.stream().filter(sporter -> sporter.getReductiebonLijst().contains(bon)).findAny()
				.orElse(null);
	}

	// EXTRA vraag1
	public List<Reductiebon> geefAlleReductiebonnenMetKortingsPercentageX(List<Integer> kortingspercentage) {
		return sportersLijst.stream().map(Sporter::getReductiebonLijst).flatMap(Collection::stream)
				.filter(bon -> kortingspercentage.contains(bon.getPercentage())).collect(Collectors.toList());
	}

	// EXTRA vraag2
	public void verwijderAlleSportersMetReductiebonMetPercX(int perc) {
		sportersLijst.removeIf(
				s -> s.getReductiebonLijst().stream().filter(bon -> bon.getPercentage() == perc).count() != 0);
	}

	public String geefSportersPerLidnr() {
		return geefAlleSleutelsEnWaarden(sporterPerLidnummer);
	}

	public String geefSportersPerAantalReductiebonnen() {
		return geefAlleSleutelsEnWaarden(sportersPerAantalReductieBonnen);
	}
	
	public Sporter geefSporter(int lidnr) {
		return sporterPerLidnummer.get(lidnr);
	}
	
	public List<Sporter> geefSportersMetEvenveelReductiebonnen(Sporter sporter){
		return sportersPerAantalReductieBonnen.get(sporter.getReductiebonLijst().size());
	}

	// OEF GENERICS
	// methode geefAlleSleutelsWaarden
	public <K extends Comparable<K>, V> String geefAlleSleutelsEnWaarden(Map<K, V> map) {
		Map<K,V> geordend = new TreeMap(map);
		return geordend.entrySet().stream().map(entry -> String.format("%s : %s", entry.getKey(), entry.getValue())).collect(Collectors.joining("\n"));
		
	}
}
