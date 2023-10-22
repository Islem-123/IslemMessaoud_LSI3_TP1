package tp1;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[]args) {
		try {
			//Crée une instance de ServerSocket qui écoute sur le port 1234.
			ServerSocket Server = new ServerSocket(1234);
			System.out.println("le serveur attend la connexion d'un client ");
			//La méthode accept() bloque le programme jusqu'à ce qu'un client se connecte. 
			Socket socket = Server.accept();
			System.out.println("Un client est connecté");
			socket.close();
			System.out.println("fermeture");
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
}
 