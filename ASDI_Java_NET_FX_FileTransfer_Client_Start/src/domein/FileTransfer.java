package domein;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class FileTransfer {
    //Attributen netwerkverbinding/streams
    //TODO
	private Socket socket;
	private Scanner socketInput;
	private Formatter socketOutput;
	private static String EOF= "*E*O*F*";
	
	
    public FileTransfer(String host) {
        try {
            //Maak verbinding met server, init attributen
            //TODO
        	socket = new Socket(host,4444);
            socketInput= new Scanner(socket.getInputStream());
            socketOutput = new Formatter(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Probleem " + ex.getMessage());
        }
    }

    public String readFile(String fileNaam) {
        //verzoek server om bestand  'fileNaam' door te sturen
        //lees het bestand in als de server het doorstuurt
        //TODO
        socketOutput.format("%s%n%s%n", "READ", fileNaam);
        socketOutput.flush();
        if(socketInput.nextLine().equals("FOUND")) {
        	StringBuilder sb = new StringBuilder();
        	String line;
        	while(!(line = socketInput.nextLine()).equals("*E*O*F*")) {
        		sb.append(line).append(System.lineSeparator());
        	}
        	return sb.toString();
        }
        
        return "BESTAND NIET GEVONDEN";
    }

    public void updateFile(String fileContents, String fileNaam) {
        //meld de server dat je het gewijzigde bestand gaat doorsturen
        //geef de eventueel gewijzigde bestandsnaam mee door
        //bij onveranderde bestandsnaam zal de server het originele bestand overschrijven
        //stuur het bestand door naar de server
        //TODO
    	socketOutput.format("%s%n%s%n", "REWRITE",  fileNaam);
    	socketOutput.flush();
    	socketOutput.format("%s%s%n", fixEOL(fileContents), EOF);
    	socketOutput.flush();
    
    }
    
    public void closeConnection() {
        try {
        //TODO
        	if(socket!=null) {
        		socket.close();
        	}
        
        } catch (IOException ex) {
            System.out.println("Probleem " + ex.getMessage());
        }
    }
    
    //De laatste regel moet eindigen met de systeem einde regel. 
    //Enkel \n of \r is niet goed.
    public String fixEOL(String text) {
        if (!text.endsWith(System.lineSeparator())) {
            int count = 0;
            int lastChar = text.length() - 1;
            if (lastChar >= 0 && (text.charAt(lastChar) == '\n' || 
                    text.charAt(lastChar) == '\r')) {
                count++;
            }
            if (lastChar > 0 && (text.charAt(lastChar - 1) == '\r')) {
                count++;
            }
            if (count > 0) {
                text = text.substring(0, text.length() - count);
            }
            return text + System.lineSeparator();
        }
        return text;
    }
    
}
