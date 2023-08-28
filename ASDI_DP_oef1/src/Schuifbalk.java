public class Schuifbalk extends ViewDecorator {

	public void draw() {
		System.out.println("Scrollbar");
		viewComponent.draw();
	}

	public Schuifbalk(ViewComponent viewComponent) {
		super(viewComponent);
	}
}
