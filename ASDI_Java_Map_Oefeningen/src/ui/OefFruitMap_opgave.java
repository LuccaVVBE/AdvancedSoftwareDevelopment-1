package ui;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OefFruitMap_opgave {

    public static void main(String args[]) {
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
        {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
        {"peche", "lichi", "kriek", "kers", "papaya"}};

        List<String> list = Stream.of(kist)//.map(Arrays::stream)
                .flatMap(Arrays::stream).collect(Collectors.toList());
        Scanner in = new Scanner(System.in);

        //declaratie + creatie map
        //------------------------------
                     Map<String,Double> fruitMap = new TreeMap<>();
                     
                            
        /*Berg de fruit list van vorige oefeningen in een boom
 op zodat dubbels ge�limineerd worden.
 Er moet ook de mogelijkheid zijn de bijhorende prijs
 (decimale waarde) bij te houden.*/
        //------------------------------------------------------------
        list.forEach(x->fruitMap.put(x,null));
        
        /*Doorloop de boom in lexicaal oplopende volgorde en vraag
 telkens de bijhorende prijs, die je mee in de boom opbergt.*/
        //------------------------------------------------------------
        //schema tak 3b
        fruitMap.entrySet().forEach(entry -> {
        	System.out.printf("Prijs van %s : ",entry.getKey() );
            double prijs = in.nextDouble();
            entry.setValue(prijs);
        });
                
           

        
        
        /*Druk vervolgens de volledige lijst in twee
 kolommen (naam : prijs) in lexicaal oplopende volgorde af
 op het scherm.*/
        //------------------------------------------------------------
        fruitMap.forEach((fruit, prijs) -> System.out.printf("%s\t%.2f%n",fruit,prijs));
                
             
    }
}
