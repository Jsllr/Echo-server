package chatbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try (ServerSocket serverSocket = new ServerSocket(5120)){ //pocket 5120 the is chosen server socket
	        System.out.println("Please wait while we are connecting to the client.....");
	        Socket clientSocket = serverSocket.accept(); //initialize client Socket
	        System.out.println("You are now connected to the client");
	        
	        try (BufferedReader br = new BufferedReader(
	                new InputStreamReader(
	                clientSocket.getInputStream()));
	            PrintWriter out = new PrintWriter(
	                clientSocket.getOutputStream(), true)) {
	        	String inputLine;
	            while ((inputLine = br.readLine()) != null) {
	                System.out.println(inputLine);
	                out.println(inputLine);
	            }
	        }
	        
	    } catch (IOException ex) {
	    	System.out.println("Sorry, connection to the client has failed");
	    }
	}

}
