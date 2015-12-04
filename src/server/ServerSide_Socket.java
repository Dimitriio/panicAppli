package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import model.User;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import server.Document;

public class ServerSide_Socket extends WebSocketServer {
	
	private Document document;
	
	public ServerSide_Socket(Document doc) throws UnknownHostException {
		super();
		this.document = doc;
	}
	
	public ServerSide_Socket(int port) throws UnknownHostException {
		super(new InetSocketAddress( port ));
	}
	
	public ServerSide_Socket(InetSocketAddress address) {
		super(address);
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " is connected !" );		
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		System.out.println( conn + " has closed connection !" );
		this.sendToAll("chatSomeone left the room...");
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("message received from : " + conn);
		
		StringTokenizer st = new StringTokenizer(message);
		
		Double la = Double.parseDouble(st.nextToken());
		Double lo = Double.parseDouble(st.nextToken());
		
		document.addUser(new User(la, lo));
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();
		if( conn != null ) {
			// some errors like port binding failed may not be assignable to a specific websocket
		}
	}
	
	public void sendToAll(String text) {
		Collection<WebSocket> connections = connections();
		for(WebSocket w : connections){
			w.send(text);
		}
	}
	
	public static void main(String[] args){
		
		WebSocketImpl.DEBUG = true;
		int port = 8887;
		System.out.println("Krokette online...");
		try {
			ServerSide_Socket ss = new ServerSide_Socket(port);
			ss.start();
			System.out.println("Server started on port : " + port);

//			BufferedReader sysin = new BufferedReader( new InputStreamReader( System.in ) );
//			while ( true ) {
//				String in = sysin.readLine();
//				ss.sendToAll( in );
//				if( in.equals( "exit" ) ) {
//					ss.stop();
//					break;
//				} else if( in.equals( "restart" ) ) {
//					ss.stop();
//					ss.start();
//					break;
//				}
//			}	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} //catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}


	
	
}
