package partie2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[]args) {
		try {
			ServerSocket Server = new ServerSocket(1234);
			System.out.println("le serveur attend la connexion d'un client ");
			Socket socket = Server.accept();
			System.out.println("un client est connecté");
			//Récupère un flux d'entrée à partir du socket client (recevoir des données du client)
			InputStream is = socket.getInputStream();
			//Récupère un flux de sortie à partir du socket client (envoyer des données au client)
			OutputStream os = socket.getOutputStream();
			//traitement
			int nb = is.read();
			int resultat = nb*5;
			os.write(resultat);
			System.out.println("Un client est connecté");
			socket.close();
			Server.close();
			System.out.println("fermeture");
		}
		catch(Exception e) 
		{
			e.printStackTrace();	}}
}






