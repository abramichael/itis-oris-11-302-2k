import java.io.*;
import java.net.*;

public class Client {

	private final static String HOST = "localhost";
	private final static int PORT = 1234;

	public static void main(String [] args) throws IOException {
		Socket s = new Socket(HOST, PORT);
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		int x = is.read();
		System.out.println("Secret from server: " + x);
	}
	
}