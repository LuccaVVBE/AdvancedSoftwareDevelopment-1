package domein;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

public class KoopjesService extends Thread {
	private List<Auto> koopjes = new ArrayList<>();
	private List<InetAddress> clients = new ArrayList<>();

	public KoopjesService() {
		try {
			clients.add(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// Gegeven: toegang tot UDP (uitvoer lijst van auto's)
		try (DatagramSocket dgSocket = new DatagramSocket()) {
			// TODO voorzie toegang tot TCP (invoer auto's)
			try (ServerSocket so = new ServerSocket(23400, 5)) {

				// start lus om telkens de info van één aanbieder te ontvangen
				while (true) {
					System.out.println("wacht op aanbieder");
					Socket socket = so.accept();

					// indien verbinding lees de info
					Scanner socketInput = new Scanner(socket.getInputStream());
					koopjes.add(new Auto(socketInput.next(), socketInput.next(), socketInput.next()));
					System.out.println("aanbieding toegevoegd");
					// beëindig de TCP verbinding
					socket.close();

					// Gegeven: maak pakketje klaar met de lijst van auto's als één string en
					// verstuur naar alle
					// alle geregistreerde ClientLuisteraars
					DatagramPacket dgPakket = new DatagramPacket(koopjes.toString().getBytes(),
							koopjes.toString().getBytes().length);
					clients.forEach(clientAddress -> {
						System.out.println("zend datagram naar client");
						try {
							dgPakket.setPort(9999);
							dgPakket.setAddress(clientAddress);
							dgSocket.send(dgPakket);
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
				}
				// einde lus
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
