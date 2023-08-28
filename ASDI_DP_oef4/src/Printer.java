public class Printer {

	private PrinterState currentState;

	private String document;
	public Printer() {
		toState(new Ready(this));
	}

	public String print(String document) {
		this.document = document;
		return currentState.print();
	}

	public String cancel() {
		return currentState.cancel();
	}

	public String getDocument() {
		return this.document;
	}

	protected void toState(PrinterState state) {
		currentState = state;
	}
}
