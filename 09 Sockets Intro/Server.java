import java.io.*;
import java.net.*;

public class Server {
	
	private final static int PORT = 1234;
	
	public static void main(String [] args) throws IOException {
		System.out.println("Starting server...");
		ServerSocket ss = new ServerSocket(PORT);
		System.out.print("Start listening on port " + PORT + "...");
		Socket s = ss.accept();
		System.out.println("Connected!");
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		os.write(100);
	}
	
}