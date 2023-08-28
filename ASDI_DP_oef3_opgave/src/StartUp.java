
import domein.Bediende;
import domein.Manager;
import domein.Werknemer;

public class StartUp {

    public static void main(String... args) {
        Werknemer werknemerJan = new Werknemer("Wolfs", "Jan", "3/5/1980", new Bediende(2000.0));

        System.out.println(werknemerJan.geefJaarInkomst());
        
        // promotie: 
        werknemerJan.setStatuut(new Manager(3000.00, 500.50));
        System.out.println(werknemerJan.geefJaarInkomst());
    }
}
