package tp1;

import java.net.Socket;

public class Client {
	public static void main(String[]args) {
		try {
			
			Socket client = new Socket("localhost",1234);
			System.out.println("je suis un client connecté");
			client.close();
			System.out.println("disconnexion");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
