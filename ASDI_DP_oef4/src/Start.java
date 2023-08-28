public class Start extends PrinterState {

	public Start(Printer printer) {
		super(printer);
	}

	public String cancel() {
		PrinterState ps = new Ready(printer);
		printer.toState(ps);
		return "Printen werd gecanceld.\n" + ps.handle();
	}

	public String handle() {
		PrinterState ps = new Printing(printer);
		printer.toState(ps);
		return "Klaar voor te printen\n" +ps.handle();
	}
}
