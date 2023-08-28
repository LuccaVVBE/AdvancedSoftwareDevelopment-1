public class Printing extends PrinterState {

	public Printing(Printer printer) {
		super(printer);
	}

	public String cancel() {
		PrinterState ps = new Ready(printer);
		printer.toState(ps);
		return "Printen werd gecanceld.\n" + ps.handle();
	}

	public String handle() {
		PrinterState ps = new End(printer);
		printer.toState(ps);
		return "Document " + printer.getDocument() + " aan het printen...\n" + ps.handle();
	}
}
