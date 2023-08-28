package persistentie;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domein.Bier;

public class BierMapper {

    public List<Bier> inlezenBieren(String naamBestand) {
    	List<Bier> bierlijst = new ArrayList<>();
    	try(Stream<String> stream = Files.lines(Paths.get(naamBestand))){
    		bierlijst = stream.map(regel -> regelToBier(regel)).collect(Collectors.toList());
    		
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return bierlijst;
    }
    

	private Bier regelToBier(String regel) {
		Scanner sc = new Scanner(regel);
		System.out.println(regel);
		Bier b = new Bier(sc.next(),sc.next(),sc.nextDouble(),sc.nextDouble(),sc.nextLine());
		return b;
	}
    
}
