public abstract class PrinterState {

	protected Printer printer;

	public String print() {
		return "printen is niet mogelijk.";
	}

	public String cancel() {
		return "cancel is niet mogelijk.";
	}

	public String handle() {
		return "Interne bewerking niet mogelijk.";
	}

	public PrinterState(Printer printer) {
		this.printer = printer;
	}
}
