package part3_;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Crée un serveur socket lié au port 1234.
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Le serveur attend la connexion d'un client");

            // Attend qu'un client se connecte et accepte la connexion lorsqu'un client se connecte.
            Socket socket = serverSocket.accept();
            System.out.println("Un client est connecté");

            // Obtient le flux d'entrée de la socket, utilisé pour recevoir des données du client.
            InputStream is = socket.getInputStream();
            // Obtient le flux de sortie de la socket, utilisé pour envoyer des données au client.
            OutputStream os = socket.getOutputStream();

            // Lire un nombre envoyé par le client depuis le flux d'entrée.
            int nb = is.read();

            // Lire le choix de l'opération  envoyé par le client depuis le flux d'entrée.
            int choice = is.read();

            int result = 0;

            // Effectue l'opération en fonction du choix de l'opération.
            switch (choice) {
                case 1:
                    result = nb + 5;
                    break;
                case 2:
                    result = nb - 5;
                    break;
                case 3:
                    result = nb * 5;
                    break;
                case 4:
                    if (nb == 0) {
                        throw new ArithmeticException("Division par zéro");
                    }
                    result = nb / 5;
                    break;
                default:
                    throw new IllegalArgumentException("Opérateur non valide");
            }

            // Envoie le résultat de l'opération au client via le flux de sortie.
            os.write(result);

            // Affiche le résultat côté serveur.
            System.out.println("Le résultat a été envoyé au client : " + result);

            // Ferme la socket pour mettre fin à la communication avec le client.
            socket.close();
            System.out.println("Fermeture du serveur");
            
        } // En cas d'erreur, affiche les détails de l'exception.
            catch (Exception e) {
            
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}