package app;

import java.net.UnknownHostException;

import krokette.MainKro;
import krokette.Server_Socket;
import server.Main;

public class Panic {

	public static void main(String[] args) {
		MainKro m = new MainKro();
		Server_Socket ss = m.getSocket();
		Thread ServerToWebSite = new Thread(m);
		Thread AndroidToServer = new Thread(new Main(ss));
		
		AndroidToServer.run();
		ServerToWebSite.run();
	}
}
