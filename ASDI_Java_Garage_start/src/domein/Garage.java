package domein;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

import persistentie.PersistentieController;

public class Garage {

	private final File auto;
	private final File onderhoud;
	private Map<String, Auto> autoMap;
	private Map<String, List<Onderhoud>> autoOnderhoudMap;
	private List<Set<Auto>> overzichtLijstVanAutos;

	private final int AANTAL_OVERZICHTEN = 3;
	private int overzichtteller;

	public Garage(String bestandAuto, String bestandOnderhoud) {
		auto = new File(bestandAuto);
		onderhoud = new File(bestandOnderhoud);
		initGarage();
	}

	private void initGarage() {
		PersistentieController persistentieController = new PersistentieController(auto, onderhoud);

		// Set<Auto> inlezen - stap1
		Set<Auto> autoSet = new HashSet<>(persistentieController.geefAutos());
		System.out.println("STAP 1");
		autoSet.forEach(auto -> System.out.println(auto));

		// Maak map van auto's: volgens nummerplaat - stap2
		autoMap = omzettenNaarAutoMap(autoSet);
		System.out.println("STAP 2");
		autoMap.forEach((k, v) -> System.out.printf("%s %s%n", k, v));

		// Onderhoud inlezen - stap3
		List<Onderhoud> onderhoudLijst = persistentieController.geefOnderhoudVanAutos();
		System.out.println("STAP 3 : " + onderhoudLijst);
		onderhoudLijst.forEach(o->System.out.println(o));

		// lijst sorteren - stap4
		sorteren(onderhoudLijst);
		System.out.println("STAP 4");
		onderhoudLijst.forEach(o->System.out.println(o));

		// lijst samenvoegen - stap5
		aangrenzendePeriodenSamenvoegen(onderhoudLijst);
		System.out.println("STAP 5");
		onderhoudLijst.forEach(o->System.out.println(o));

		// Maak map van onderhoud: volgens nummerplaat - stap6
		autoOnderhoudMap = omzettenNaarOnderhoudMap(onderhoudLijst);
		System.out.println("STAP 6");
		autoOnderhoudMap.forEach((k,v)->System.out.printf("%s %s%n",k,v));

		// Maak overzicht: set van auto's - stap7
		overzichtLijstVanAutos = maakOverzicht(autoOnderhoudMap);
		System.out.println("STAP 7");
		overzichtLijstVanAutos.forEach(System.out::println);
	}

	// Maak map van auto's: volgens nummerplaat - stap2
	private Map<String, Auto> omzettenNaarAutoMap(Set<Auto> autoSet) {
		return autoSet.stream().collect(Collectors.toMap(Auto::getNummerplaat, a -> a));
	}

	// lijst sorteren - stap4
	private void sorteren(List<Onderhoud> lijstOnderhoud) {
		lijstOnderhoud.sort(Comparator.comparing(Onderhoud::getNummerplaat).thenComparing(Onderhoud::getBegindatum));
	}

	// lijst samenvoegen - stap5
	private void aangrenzendePeriodenSamenvoegen(List<Onderhoud> lijstOnderhoud) {
//java 7
		Onderhoud onderhoud = null;
		Onderhoud onderhoudNext = null;
		Iterator<Onderhoud> it = lijstOnderhoud.iterator();

		while (it.hasNext()) {
			onderhoud = onderhoudNext;
			onderhoudNext = it.next();
			if (onderhoud != null && onderhoud.getNummerplaat().equals(onderhoudNext.getNummerplaat())) {
				if (onderhoud.getEinddatum().plusDays(1).equals(onderhoudNext.getBegindatum())) {// samenvoegen:
					onderhoud.setEinddatum(onderhoudNext.getEinddatum());
					it.remove();
					onderhoudNext = onderhoud;
				}
			}
		}

	}

	// Maak map van onderhoud: volgens nummerplaat - stap6
	private Map<String, List<Onderhoud>> omzettenNaarOnderhoudMap(List<Onderhoud> onderhoudLijst) {
		return onderhoudLijst.stream().collect(Collectors.groupingBy(Onderhoud::getNummerplaat));
	}

	// Hulpmethode - nodig voor stap 7
	private int sizeToCategorie(int size) {
		return switch (size) {
		case 0, 1 -> 0;
		case 2, 3 -> 1;
		default -> 2;
		};
	}

	// Maak overzicht: set van auto's - stap7
	private List<Set<Auto>> maakOverzicht(Map<String, List<Onderhoud>> autoOnderhoudMap) {
		// Hint:
		// van Map<String, List<Onderhoud>>
		// naar Map<Integer, Set<Auto>> (hulpmethode gebruiken)
		// naar List<Set<Auto>>
		return autoOnderhoudMap.entrySet().stream().collect(Collectors.groupingBy(entry->sizeToCategory(entry.getValue().size()),
				TreeMap::new,Collectors.mapping(entry-> autoMap.get(entry.getKey()),Collectors.toSet()).values().stream()
				.collect(Collectors.toList());
	}

//Oefening DomeinController:
	public String autoMap_ToString() {
		// String res = autoMap.
		return null;
	}

	public String autoOnderhoudMap_ToString() {
		 String res = autoOnderhoudMap.toString();
		return res;
	}

	public String overzicht_ToString() {
		overzichtteller = 1;
		// String res = overzichtLijstVanAutos.
		return null;
	}

}
