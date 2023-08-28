public abstract class ReaderDecorator implements Reader {

	protected Reader reader;

	public ReaderDecorator(Reader reader) {
		this.reader = reader;
	}
}
