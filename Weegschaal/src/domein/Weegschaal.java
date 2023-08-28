package domein;

import java.math.BigInteger;



public class Weegschaal {

	private BigInteger gewicht = BigInteger.ZERO;
	


	public BigInteger getGewicht() {
		return this.gewicht;
	}

	public void vermeerder(BigInteger gewicht) {
		if(gewicht == null || gewicht.signum()<0)
			throw new IllegalArgumentException("Foutieve invoerwaarde");
		this.gewicht = this.gewicht.add(gewicht);
	}
}
