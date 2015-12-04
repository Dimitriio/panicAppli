package krokette;

import java.io.IOException;
import java.net.UnknownHostException;

import org.java_websocket.WebSocketImpl;

public class MainKro implements Runnable{

	public void run() {
		WebSocketImpl.DEBUG = true;
		int port = 8887;
		System.out.println("Krokette online...");
		try {
			Server_Socket ss = new Server_Socket(port);
			ss.start();
			System.out.println("Server started on port : " + port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
