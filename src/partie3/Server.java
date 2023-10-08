package partie3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
     public static void main(String[] args)  {
      try {
    	  
          System.out.println("je suis un serveur");
          ServerSocket serverSocket = new ServerSocket(1234); 
  		  System.out.println("le serveur attend la connexion d'un client ");
          Socket socket=serverSocket.accept(); 
          System.out.println("un client est connecté");
          InputStream is = socket.getInputStream(); 
          OutputStream os = socket.getOutputStream(); 
          int nb=is.read(); 
          int resultat =nb*5;
          os.write(resultat);
          System.out.println("déconnexion serveur");
          socket.close();
          serverSocket.close();
          }
      catch(Exception e) 
      {
    	  e.printStackTrace();
      }
}

}

		
		
