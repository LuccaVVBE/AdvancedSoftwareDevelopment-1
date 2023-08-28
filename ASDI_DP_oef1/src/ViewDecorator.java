public abstract class ViewDecorator implements ViewComponent {

	protected ViewComponent viewComponent;

	public ViewDecorator(ViewComponent viewComponent) {
		this.viewComponent = viewComponent;
	}
}
