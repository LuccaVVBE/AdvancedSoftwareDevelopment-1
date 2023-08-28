package persistentie;

import java.io.EOFException;
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
        //TODO
    	List<Bier> bieren = new ArrayList<>();
    	try(Stream<String> stream = Files.lines(Paths.get(naamBestand))){
    		bieren = stream.map(regel->regelToBier(regel)).collect(Collectors.toList());
    	}catch(EOFException eof) {
    		System.out.println("End of file: ");
    		System.out.println(eof.getLocalizedMessage());
    	}catch(Exception e) {
    		System.out.println(e.getLocalizedMessage());
    	}
    	return bieren;
    }
    
    private Bier regelToBier(String regel) {
    	Scanner sc = new Scanner(regel);
		Bier b = new Bier(sc.next(),sc.next(),sc.nextDouble(),sc.nextDouble(),sc.nextLine());
		return b;
    }
}
