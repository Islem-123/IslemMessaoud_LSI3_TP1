package partie3;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
public class Client {
	public static void main(String[]args) {

		try  {

			//Crée une instance de la classe InetAddress pour représenter l'adresse IP "10.27.15.178"
			InetAddress inetAdress = InetAddress.getByName("10.27.15.178");
			InetSocketAddress inetSocketAdre = new InetSocketAddress(inetAdress,1234); 
			//Crée un socket client.
			Socket client = new Socket();

			client.connect(inetSocketAdre);//one le fait pour connecter à une autre adresse de pc
			System.out.println("je suis un client connecté");
		//Récupère un flux d'entrée à partir du socket client. Cela permettra au client d'envoyer des données au serveur
			InputStream is = client.getInputStream();
		//Récupère un flux de sortie à partir du socket client. Cela permettra au client d'envoyer des données au serveur

			client.connect(inetSocketAdre);//hetha namlou fih bch nconnectiw ala adresse okhra pc okhra lkdhma hiya nfsha juste socket client hatitha fi comment 
	
			System.out.println("je suis un client connecté");
			//Récupère un flux d'entrée à partir du socket client. Cela permettra au client d'envoyer des données au serveur
			InputStream is = client.getInputStream();//hachtna bch nbathou lil serveur nb*5 kifh ikoun 
			//Récupère un flux de sortie à partir du socket client. Cela permettra au client d'envoyer des données au serveur

			OutputStream os = client.getOutputStream();
			int nb;
			System.out.println("nb= ");	
			//Utilise un objet Scanner pour lire un entier
			try (Scanner scanner = new Scanner(System.in)) {
				nb=scanner.nextInt();
			}
			//Envoie le nombre nb au serveur via le flux de sortie.
			os.write(nb);
			//Lit une réponse du serveur à partir du flux d'entrée et la stocke dans la variable response
			int response =is.read();
			//Affiche le nombre reçu du serveur.
			System.out.println("le nombre est "+response);
			//Ferme le socket client et libère la mémoire
			client.close();

			System.out.println("disconnexion");	
		} catch (Exception e) {
			e.printStackTrace();}

			System.out.println("disconnexion");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}


