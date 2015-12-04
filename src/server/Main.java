package server;

import java.util.StringTokenizer;

import krokette.MainKro;
import krokette.Server_Socket;

public class Main implements Runnable{
	
	private Document document;
	private ServerSide_Socket connection;
	private Server_Socket ss;
	
	public Main(Server_Socket ss) {
		this.ss = ss;
	}

	public void server () {
		int port = 9555;
		try {
			document = new Document();
			connection = new ServerSide_Socket(port, document, ss);
			connection.start();
			System.out.println("Server started on port : " + port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		Main m = new Main();
		m.server();
	}*/

	public void run() {
		this.server();
	}

}

