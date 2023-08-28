public class EncryptedReader extends ReaderDecorator {

	public String read() {
		return "Encrypted: " + reader.read();
	}

	public EncryptedReader(Reader reader) {
		super(reader);
	}
}
