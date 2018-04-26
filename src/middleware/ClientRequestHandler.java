package middleware;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientRequestHandler {

	private String host;
	private int port;

	private Socket clientSocket;
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;

	public ClientRequestHandler(final String host, final int port) {
		this.host = host;
		this.port = port;
	}

	public void close() throws IOException {
		this.clientSocket.close();
		this.outToServer.close();
		this.inFromServer.close();
	}

	public void create() throws UnknownHostException, IOException {
		this.clientSocket = new Socket(this.host, this.port);
		this.outToServer = new ObjectOutputStream(this.clientSocket.getOutputStream());
		this.inFromServer = new ObjectInputStream(this.clientSocket.getInputStream());
	}

	public byte[] receive() throws ClassNotFoundException, IOException {
		byte[] reply = (byte[]) this.inFromServer.readObject();
		return reply;
	}

	public void send(final byte[] message) throws IOException {
		if (this.clientSocket.isClosed()) {
			throw new IOException("clientSocket closed.");
		}

		this.outToServer.writeObject(message);
		this.outToServer.flush();
	}
}