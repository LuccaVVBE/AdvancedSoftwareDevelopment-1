package domein;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;

import repository.ReductiebonDao;
import repository.ReductiebonDaoJpa;

public class ReductiebonBeheerder {

	private ReductiebonDao reductiebonDao;
	private List<Reductiebon> reductiebonLijst;

	public ReductiebonBeheerder() {
		reductiebonDao = new ReductiebonDaoJpa();
		reductiebonLijst = reductiebonDao.findAll();
	}

	public List<Reductiebon> getReductiebonLijst() {
		return Collections.unmodifiableList(reductiebonLijst);
	}

	// VRAAG1
	public List<String> geefReductiebonCodes(int percentage) {
		return reductiebonLijst.stream()
				.filter(x->x.getPercentage()>percentage)
				.map(x->x.getReductiebonCode())
				.collect(Collectors.toList());
		
	}

	// VRAAG2
	public void sorteerReductiebonnen() {
		reductiebonLijst.sort(Comparator.comparing(Reductiebon::getPercentage)
				.thenComparing(Comparator.comparing(Reductiebon::getReductiebonCode).reversed()));
		
	}

	// VRAAG3
	public double geefGemPercVanBonnenInToekomst() {
		
		return reductiebonLijst.stream().filter(x->x.getEinddatum().compareTo(LocalDate.now())>0)
				.mapToInt(x->x.getPercentage()).average().getAsDouble();
				//.orElse(0);
	}

	// VRAAG4
	public List<LocalDate> geefUniekeEinddatums() {
		return reductiebonLijst.stream().map(x->x.getEinddatum()).distinct().sorted().collect(Collectors.toList());

	}
}
