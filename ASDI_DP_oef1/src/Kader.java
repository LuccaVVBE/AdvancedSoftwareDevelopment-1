public class Kader extends ViewDecorator {
	
	private int dikte;
	
	public void draw() {
		System.out.println("Kader met dikte: " + dikte);
		viewComponent.draw();
	}

	public Kader(ViewComponent viewComponent, int dikte) {
		super(viewComponent);
		this.dikte = dikte;
	}
}
