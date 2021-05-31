package chatbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
	        System.out.println("Waiting to connect to the server.....");
	        InetAddress localAddress = InetAddress.getLocalHost();

	        try (Socket clientSocket = new Socket(localAddress, 5120);
	        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	        		clientSocket.getInputStream()))) {
	        	System.out.println("Successfully connected to server");
	            Scanner scanner = new Scanner(System.in);
	            while (true) {
	                System.out.print("Enter message here: (enter quit to terminate the program): ");
	                String inputLine = scanner.nextLine();
	                if ("quit".equalsIgnoreCase(inputLine)) {
	                	scanner.close();
	                    break;
	                }
	                out.println(inputLine);
	                String response = br.readLine();
	                System.out.println("Server response: " + response);
	            }
	        }
	    } catch (IOException ex) {
	    	System.out.println("Failed to connect to the Server");
	    }
	}

}
