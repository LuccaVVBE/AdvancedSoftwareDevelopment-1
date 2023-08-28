package clients;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientLuisteraar {
	public static void main(String[] args) {
		new ClientLuisteraar().run();
	}
	private void run() {
		System.out.println("Client Luisteraar ontvangt de lijst");
		//Gegeven:
		//      Maak een UDP toegang om een pakket te ontvangen op poort 9999
		//      Wacht op het pakket en toon de ontvangen lijst van auto's af op het scherm
		//      Beeindig de client
		try (DatagramSocket dgSocket = new DatagramSocket(9999)){
			byte[] buffer = new byte[100];
			DatagramPacket dgPacket = new DatagramPacket(buffer, buffer.length);
			dgSocket.receive(dgPacket);
			System.out.println(new String(dgPacket.getData(), dgPacket.getOffset(), dgPacket.getLength()));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
