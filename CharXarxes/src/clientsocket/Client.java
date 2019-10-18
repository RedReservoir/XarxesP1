package clientsocket;

import java.io.*; 
import java.net.Socket; 
import java.util.Scanner; 

public class Client {

	public static void main(String[] args) {
		try { 
            Scanner entradaDades = new Scanner(System.in);
            System.out.println("Introdueix la IP del host");
            String IP_Address = entradaDades.next(); 
            System.out.println("introdueix el port");
            int port = entradaDades.nextInt();
            entradaDades.close();
            
            Socket socket = new Socket(IP_Address, port);

            try { 
                InputStream entrada = socket.getInputStream(); 
                OutputStream salida = socket.getOutputStream(); 

                Scanner in = new Scanner(entrada); 
                while(in.hasNextLine()){ 
                    String linia = in.nextLine(); 
                    System.out.println(linia); 
                }
                in.close();
                //Comment next 3 lines : Can't send data to the clock
                /*
                PrintWriter out = new PrintWriter(salida, true); 
                String dadesAEnviar = in.next(); 
                out.println(dadesAEnviar); 
                */
            } finally { 
                socket.close();
            } 

        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
	}

}
