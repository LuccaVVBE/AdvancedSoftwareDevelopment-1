package main;
import java.util.*;
//Gegeven:

abstract class Dier {
}

interface Huisdier {
}

class Hond extends Dier implements Huisdier {
}

class Kat extends Dier implements Huisdier {
}

//Gevraagd:
//schrijf een klasse die een set van Kat, Hond of Huisdier kan bevatten
class VerzamelingHuisdier<T>
//------



{
	//attribuut "huisdieren" = set van Kat, Hond of Huisdier
	//--------------------------------------------------------------------------
	private Set<T> huisdieren = new HashSet<>();
    //getHuisdieren
	//-------------------
	public Set<T> getHuisdieren(){
		return Collections.unmodifiableSet(huisdieren);
	}
    //methode add: een dier toevoegen in de set
	//------------------------------------------------------------
	public void add(T dier) {
		huisdieren.add(dier);
	}
}

class Tools {
//methode bevatHuisdier met twee argumenten: een huisdier en een set van Kat, Hond of Huisdier.
//Geeft true terug indien het huisdier in de set voorkomt, anders false.
	
		
//schrijf de static methode bevatHuisdier d.m.v. wildcards
//---------------------------------------------------------------------------------------
	public static boolean bevatHuisdier(Huisdier hd, Set<? extends Huisdier>dieren) {
		return dieren.contains(hd);
		
	}
//schrijf de static methode bevatHuisdier2 d.m.v. generieke methode
//---------------------------------------------------------------------------------------
	public static <T extends Huisdier>  boolean bevatHuisdier2(T dier, Set<T> huisdieren) {
		return huisdieren.contains(dier);
	}
//schrijf de static methode geefAantal. E�n argument: Een set van Kat, Huisdier of Object.	
//Aantal elementen van de set wordt teruggegeven.
//---------------------------------------------------------------------------------------	
	public static int geefAantal(Set<? super Kat> set) {
		return set.size();
	}
}

public class Generieke_klasse_opgave {

    public static void main(String args[]) {
        Kat kat = new Kat();
        Hond hond = new Hond();
        Huisdier huisdier = new Hond();

        VerzamelingHuisdier<Kat> katten = new VerzamelingHuisdier<>();
        katten.add(kat);
        VerzamelingHuisdier<Hond> honden = new VerzamelingHuisdier<>();

        VerzamelingHuisdier<Huisdier> huisdieren = new VerzamelingHuisdier<>();
        huisdieren.add(huisdier);

        boolean komtVoor = Tools.bevatHuisdier(kat, katten.getHuisdieren());
        System.out.printf("correct = true;  %s%n", komtVoor);
        komtVoor = Tools.bevatHuisdier(hond, honden.getHuisdieren());
        System.out.printf("correct = false;  %s%n", komtVoor);
        komtVoor = Tools.bevatHuisdier(huisdier, huisdieren.getHuisdieren());
        System.out.printf("correct = true;  %s%n", komtVoor);
        //compileerfout: komtVoor = Tools.bevatHuisdier(kat, new HashSet<Dier>());

        komtVoor = Tools.bevatHuisdier2(kat, katten.getHuisdieren());
        System.out.printf("correct = true;  %s%n", komtVoor);
        komtVoor = Tools.bevatHuisdier2(hond, honden.getHuisdieren());
        System.out.printf("correct = false;  %s%n", komtVoor);
        komtVoor = Tools.bevatHuisdier2(huisdier, huisdieren.getHuisdieren());
        System.out.printf("correct = true;  %s%n", komtVoor);
        
        int aantalKatten = Tools.geefAantal(katten.getHuisdieren());
        int aantalHuisdieren = Tools.geefAantal(huisdieren.getHuisdieren());
        //compileerfout: int aantalHonden = Tools.geefAantal(honden.getHuisdieren());
        int aantalObjecten = Tools.geefAantal(new HashSet<Object>());
        
        System.out.printf("correct = 1;  %d%ncorrect = 1;  %d%ncorrect = 0;  %d%n", aantalKatten, 
        		aantalHuisdieren, aantalObjecten);
    }

}
