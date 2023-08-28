public class Ready extends PrinterState {

	public Ready(Printer printer) {
		super(printer);
	}

	public String print() {
		PrinterState ps = new Start(printer);
		printer.toState(ps);
		return "Wachten op document...\n" + ps.handle();
	}
}
