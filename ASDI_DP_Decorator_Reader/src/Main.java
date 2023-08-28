
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader fr = new FileReader("tekst.txt");
		Reader zip = new ZippedReader(new FileReader("tekst.txt"));
		Reader enc = new EncryptedReader(new FileReader("tekst.txt"));
		Reader enc2 = new EncryptedReader(new ZippedReader(new FileReader("test.txt")));
		Reader enc3 = new EncryptedReader(new ZippedReader(new EncryptedReader(new FileReader("tekst.txt"))));
		
		System.out.println(fr.read()); //tekst
		System.out.println(zip.read()); //"zipped tekst"
		System.out.println(enc.read()); //encrytped tekst
		System.out.println(enc2.read()); // encrytped zipped tekst
		System.out.println(enc3.read()); //encrypted zipped encrypted tekst
		
		
	}

}
