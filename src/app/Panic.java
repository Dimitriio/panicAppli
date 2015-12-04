package app;

import java.net.UnknownHostException;

import krokette.MainKro;
import server.Main;

public class Panic {

	public static void main(String[] args) {
		Thread AndroidToServer = new Thread(new Main());
		Thread ServerToWebSite = new Thread(new MainKro());
		AndroidToServer.run();
		ServerToWebSite.run();
	}
}
