package part3_;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Crée une socket client  et se connecte au serveur sur le port 1234 de l'ordinateur local .
            Socket client = new Socket("localhost", 1234);
            System.out.println("Je suis un client connecté");

            // Obtient le flux d'entrée de la socket, utilisé pour recevoir des données du serveur.
            InputStream is = client.getInputStream();

            // Obtient le flux de sortie de la socket, utilisé pour envoyer des données au serveur.
            OutputStream os = client.getOutputStream();

            // Demande à l'utilisateur de saisir un nombre et le lit depuis l'entrée standard .
            Scanner scanner = new Scanner(System.in);
            System.out.print("le nombre est : ");
            int nb = scanner.nextInt();
            // Envoie le nombre au serveur.
            
            os.write(nb);

            // Demande à l'utilisateur de choisir une opération (1, 2, 3 ou 4) et la lit depuis l'entrée standard.
            int choice;
            do {
                System.out.println("laquelle d'opérations voulez vous ? : ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 4);
            // Envoie le choix de l'opération au serveur.
            os.write(choice); 
            
            // Lit la réponse du serveur, qui est le résultat de l'opération, depuis le flux d'entrée.
            int response = is.read();
            System.out.println("Le résultat après avoir appliquer l'opération est " +response);

            // Ferme la socket cliente pour mettre fin à la communication avec le serveur.
            client.close();
            System.out.println("Déconnexion");
        } 
     // En cas d'erreur, affiche les détails de l'exception.
        catch (Exception e)
        {
            e.printStackTrace(); 
        }
    }
}