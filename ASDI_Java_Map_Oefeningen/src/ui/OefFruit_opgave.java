package ui;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CollectionOperaties {
    
    //methode verwijderOpLetter
    //-------------------------
	public static boolean verwijderOpLetter(Collection<String> list, char c) {
//		Iterator<String> it = list.iterator();
//		while(it.hasNext()) {
//			if(it.toString().charAt(0) == c)
//				it.remove();
//		}
		return list.removeIf(x->x.charAt(0)==c);
	}
    //methode verwijderSequence
    //-------------------------
	public static boolean verwijderSequence(List<String> list, String s) {
		int first = list.indexOf(s);
		if(first == -1)
			return false;
		int last = list.lastIndexOf(s);
		list.subList(first, last).clear();
		return true;

	}
	//uitbreiding opgave Fruit   addOrdered
	//-------------------------------------
	public static boolean addOrdered(List<String> list, String string) {
		// TODO Auto-generated method stub
		int index = Collections.binarySearch(list, string);
		if(index >=0)
			return false;
		list.add(index*-1-1, string);
		
		
		return true;
	}
}

public class OefFruit_opgave {

    public static void main(String args[]) {
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
        {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
        {"peche", "lichi", "kriek", "kers", "papaya"}};

        
        //Arrays.asList(kist).stream();
        //Arrays.stream(kist);
        
        
        List<String> list = Stream.of(kist)//.map(Arrays::stream)
                .flatMap(Arrays::stream).collect(Collectors.toList());
        String mand[] ;

//Toon de inhoud van de array "kist"
//----------------------------------
        System.out.println();
        
//Voeg de verschillende kisten samen in een ArrayList list.
//--------------------------------------------------------


        CollectionOperaties.verwijderOpLetter(list, 'p');
        System.out.println("na verwijder letter ('p') :  " + list + "\n");

        CollectionOperaties.verwijderSequence(list, "kiwi");
        System.out.println("na verwijder sequence (kiwi) : " + list + "\n");
        
        list.sort(null);
        CollectionOperaties.addOrdered(list, "Sapodilla");

//Plaats het resultaat terug in een array mand en sorteer die oplopend.
//---------------------------------------------------------------------
        mand = list.toArray(new String[0]);
        Arrays.sort(mand);

//Toon de inhoud van de array "mand"
//----------------------------------
        System.out.println(Arrays.toString(mand));

    }
}
