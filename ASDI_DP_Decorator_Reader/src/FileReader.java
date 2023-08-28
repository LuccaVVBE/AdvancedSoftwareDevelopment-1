public class FileReader implements Reader {
	
	String name;
	
	public String read() {
		return name;
	}

	public FileReader(String name) {
		this.name = name;
	}
}
