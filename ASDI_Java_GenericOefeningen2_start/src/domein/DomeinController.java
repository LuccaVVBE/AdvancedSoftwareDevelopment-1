package domein;

import java.io.File;
import java.util.List;

import persistentie.PersistentieController;

public class DomeinController {
    
    private PersistentieController pc = new PersistentieController();
    
    public void persisteerBierGegevensAlsObject(String tekstFileNaam, String objectFileNaam){    
    	//TODO zie stap3
        List<Bier> listBier = pc.leesBieren(new File(tekstFileNaam));
        MyListIterable<Bier> myList = new MyListIterable<>();
        listBier.forEach(myList::insertAtBack);
        pc.persisteerObject(myList, new File(objectFileNaam));
        
    }
    
}
