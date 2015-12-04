package krokette;

import java.io.IOException;
import java.net.UnknownHostException;

import org.java_websocket.WebSocketImpl;

import krokette.Server_Socket;

public class MainKro implements Runnable{
	
	private Server_Socket ss;
	int port;
	
	public MainKro(){
		port = 8887;
		try {
			ss = new Server_Socket(port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void run() {
		WebSocketImpl.DEBUG = true;
		System.out.println("Krokette online...");
		ss.start();
		System.out.println("Server started on port : " + port);
	}

	public Server_Socket getSocket() {
		return this.ss;
	}

}
