package domein;

public class Held {

	private Wapen wapen;

	public Held() {
		setWapen(new Handen());
	}
	
	public void valAan() {
		wapen.valAan();
	}

	public void setWapen(Wapen w) {
		if(w != null )
			this.wapen = w;
		else
			wapen = new Handen();
	}
}
