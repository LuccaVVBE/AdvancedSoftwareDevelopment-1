package clients;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Formatter;

public class ClientAanbieder {
	
	public static void main(String[] args) {
		new  ClientAanbieder().run();
	}


	private void run() {
		System.out.println("Client Aanbieder stuurt een aanbieding");
		//TODO Maak een TCP verbinding met localhost op poort 23400
		//     Stuur een regel (= auto in aanbieding) "1DEF256", "Opel", "Combo"
		//     Beeindig de client
		try(Socket socket = new Socket(InetAddress.getLocalHost(),23400)){
			Formatter socketOut = new Formatter(socket.getOutputStream());
			socketOut.format("%s %s %s%n",  "1DEF256", "Opel", "Combo");
			socketOut.flush();
			socketOut.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
