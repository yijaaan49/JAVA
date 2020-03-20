package kjjkl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
	Server(){
	}
	
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(10000);
			Socket so = server.accept();
			System.out.println(so.getInetAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}