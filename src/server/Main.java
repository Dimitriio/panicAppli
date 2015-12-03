package server;

public class Main {
	
	private Document document;
	private ServerSide_Socket connection;
	
	public void server () {
		int port = 9555;
		try {
			document = new Document();
			connection = new ServerSide_Socket(port);
			connection.start();
			System.out.println("Server started on port : " + port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.server();
	}

}

