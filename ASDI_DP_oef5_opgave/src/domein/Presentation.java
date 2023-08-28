package domein;

public class Presentation extends Document {

    public Presentation(String filePath) {
        super(filePath);
    }

    @Override
    public void loadFromFile(String filePath) {
        // TODO Auto-generated method stub	
    }

    @Override
    public void preview() {
        // TODO Auto-generated method stub
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
    	System.out.println("Dit is een print van presentation");
    }

}
