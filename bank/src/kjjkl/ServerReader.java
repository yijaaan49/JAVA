package kjjkl;

import java.net.Socket;

public class ServerReader extends Thread {
	Server sr = new Server();
	sr.
	Socket socket;
	
	
	public ServerReader(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
}
