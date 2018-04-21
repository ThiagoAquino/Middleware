import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class ClientRequestHandler {
	private String host;
	private int port;
	
	Socket clientsocket = null;
	ObjectOutputStream outToServer = null;
	ObjectInputStream inFromServer = null;
	
	public ClientRequestHandler(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	
	public void send(Message msg) throws IOException, InterruptedException {
		
	}
	
	public Message receive()  throws IOException, InterruptedException {
		Message retorno = null;
		return retorno;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}
	
	
	
}
