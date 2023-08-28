public class End extends PrinterState {

	public End(Printer printer) {
		super(printer);
	}

	public String handle() {
		PrinterState ps = new Ready(printer);
		printer.toState(ps);
		return "Document werd geprint.\n";
	}
}
