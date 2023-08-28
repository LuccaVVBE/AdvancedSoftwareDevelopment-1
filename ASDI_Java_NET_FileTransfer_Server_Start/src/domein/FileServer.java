package domein;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.Formatter;
import java.util.Scanner;

public class FileServer {
    //attributen voor netwerkconnectie en streams
   //TODO
	private Socket socket;
	private Scanner sockInput;
	private Formatter sockOutput;
	private final static String EOF = "*E*O*F*";
	
	
    public void run() {
        //initialiseer server
        //TODO
        try (ServerSocket serverSocket = new ServerSocket(4444, 9)) {
            System.out.println("Fileserver up");
            
            //wacht tot een client verbindig maakt
            //verwerk al de verzoeken van een client tot deze afsluit
            //          delegeer naar hulpmethode processClient
            //wacht opnieuw op een client, blijft dit doen
            //TODO
            while (true) {
                try {	
                    System.out.println("Fileserver waiting...");

                    socket = serverSocket.accept();
                    processClient();
                    
                    

                } catch (IOException ex) {
                    System.out.println("Problemen : " + ex.getMessage());
                } 
            }
        } catch (IOException ex) {
            System.out.println("Problemen met server connectie : " + 
                                                ex.getMessage());
        } 
    }

    private void processClient() {
        //verwerk al de verzoeken van een client volgens het afgesproken protocol 
        //tot deze afsluit
        //sluit dan ook de connectie met deze client
        //maak gebruik van de 3 onderstaande hulpmethoden
        try {
        	sockInput = new Scanner(socket.getInputStream());
        	sockOutput = new Formatter(socket.getOutputStream());
        	while(sockInput.hasNext()) {
        	String actie = sockInput.nextLine();
        	File file;
        	switch(actie) {
        		case "READ"->{
        			file = new File(sockInput.nextLine());
        			System.out.println("READ" + file.getName());
        			if(file.exists()) {
        			sendFile(file);
        			}
        			else {
        			sendNoFile();
        			}
        	
        	}
        	case "REWRITE" ->{
        		file = new File(sockInput.nextLine());
        		System.out.println("REWRITE " + file.getName());
        	}
        	}
        	sockInput.close();
        	sockOutput.close();
        	}
 
        } catch (IOException ex) {
            System.out.println("Problemen met client connectie : " + 
                    ex.getMessage());
        }
    
        
    }

        	

    private void sendFile(File file) throws IOException {
        //TODO
           sockOutput.format("%s%n", "FOUND");
           sockOutput.flush();
           try(Scanner diskFile = new Scanner(file)){
        	   while(diskFile.hasNext()) {
        		   sockOutput.format("%s%n", diskFile.nextLine());
        	   }
        	   sockOutput.format("%s%n", EOF);
        	   sockOutput.flush();
           }
    }

    private void sendNoFile() {
        //TODO
    	sockOutput.format("%s%n", "NOTFOUND");
    	sockOutput.format("%s%n", EOF);
 	    sockOutput.flush();
    }
    
    private void readAndSaveUpdateFile(File file) throws IOException {
        //TODO
        String line;
        try(Formatter disk = new Formatter(file)){
        	while (!(line = sockInput.nextLine()).equals(EOF)) {
        		disk.format("%s%n", line);
        	}
        } catch(IOException ioe) {
        	System.err.println(ioe.getLocalizedMessage());
        }
    }

}
