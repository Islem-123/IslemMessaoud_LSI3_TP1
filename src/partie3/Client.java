package partie3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {


	public static void main(String[] args)  {
	try
	{
	   System.out.println("je suis un client");
	   Socket socket=new Socket("192.168.0.6",1234); 
	   System.out.println("je suis un client connecté");
	   InputStream is = socket.getInputStream(); 
	   OutputStream os = socket.getOutputStream(); 
	   int nb;
	   System.out.println("donner une valeur");
	   Scanner scanner= new Scanner(System.in);
	   nb=scanner.nextInt();
	   os.write(nb); 
	   System.out.println("la multiplication de "+nb+"*5 = "+is.read()); 
	   System.out.println("deconnexion client");
	       socket.close();
	}
	
	catch(Exception e) {e.printStackTrace();};

	}
}
