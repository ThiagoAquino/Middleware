package middleware;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientRequestHandler {
	private String host;
	private int port;

	Socket clientsocket = null;
	ObjectOutputStream outToServer = null;
	ObjectInputStream inFromServer = null;

	public ClientRequestHandler(String host, int port) throws UnknownHostException, IOException {
		this.host = host;
		this.port = port;
		clientsocket = new Socket(host, port);
	}


	public void send(byte [] msg) throws IOException {
		outToServer = new ObjectOutputStream(clientsocket.getOutputStream());
		outToServer.writeObject(msg);

	}

	public byte [] receive()  throws IOException, InterruptedException, ClassNotFoundException {
		inFromServer = new ObjectInputStream(clientsocket.getInputStream());
		//Message retorno = (Message) inFromServer.readObject();
		//return retorno;
		return (byte[]) inFromServer.readObject();
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

	public void closeConnection() throws IOException {
		this.clientsocket.close();
	}

}
