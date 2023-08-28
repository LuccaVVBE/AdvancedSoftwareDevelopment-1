public class ZippedReader extends ReaderDecorator {


	public String read() {
		return "Zipped: "  +reader.read();
	}

	public ZippedReader(Reader reader) {
		super(reader);
	}
}
