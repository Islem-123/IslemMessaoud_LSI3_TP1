package partie2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[]args) {
		try {
			Socket client = new Socket("localhost",1234);
			System.out.println("je suis un client connecté");
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			int nb;
			System.out.println("nb= ");
			try (Scanner scanner = new Scanner(System.in)) {
				nb=scanner.nextInt();
			}
			os.write(nb);
			int response =is.read();
			System.out.println("le nombre est "+response);
			client.close();//libération de memoire , liberer socket et localhost
			System.out.println("disconnexion");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}