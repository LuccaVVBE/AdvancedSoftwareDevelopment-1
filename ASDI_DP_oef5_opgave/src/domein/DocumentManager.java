package domein;

public class DocumentManager {

    public void print(String filePath) {
        DocumentFactory.createDocument(filePath).print();
    }

    public void preview(String filePath) {
        DocumentFactory.createDocument(filePath).preview();
    }
}
