package testen;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import domein.Weegschaal;

public class WeegschaalTest {
	private Weegschaal weegschaal;
	
	@BeforeEach
	public void beforeEach() {
		weegschaal = new Weegschaal();
	}
	
	@Test
	public void gewichtVermeerderen() {
		BigInteger gewicht = new BigInteger("15");
		
		weegschaal.vermeerder(gewicht);
		Assertions.assertEquals(gewicht, weegschaal.getGewicht());
		}
	
	@Test
	public void nieuweWeegschaalGeeftGewichtNul() {
		Assertions.assertEquals(BigInteger.ZERO,  weegschaal.getGewicht());
		
		}
	
	@Test
	public void gewichtVermeerderenMetNegatieveWaarde() {
		BigInteger gewicht = new BigInteger("-20");
		Assertions.assertThrows(IllegalArgumentException.class, () -> weegschaal.vermeerder(gewicht));
		}
	
	@Test
	public void gewichtVermeerderenMetNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {weegschaal.vermeerder(null);});
	}
	
}

