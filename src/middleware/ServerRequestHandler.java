package middleware;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRequestHandler {

	private ServerSocket serverSocket;
	private Socket connectionSocket;

	private ObjectOutputStream outToClient;
	private ObjectInputStream inFromClient;

	public ServerRequestHandler(final int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
	}

	public void send(final byte[] message) throws IOException {
		this.outToClient.writeObject(message);
		this.outToClient.flush();
	}

	public byte[] receive() throws IOException, ClassNotFoundException {
		return (byte[]) this.inFromClient.readObject();
	}

	public void create() throws IOException {
		this.connectionSocket = this.serverSocket.accept();
		this.outToClient = new ObjectOutputStream(this.connectionSocket.getOutputStream());
		this.inFromClient = new ObjectInputStream(this.connectionSocket.getInputStream());
	}

	public void close() throws IOException {
		this.connectionSocket.close();
		this.outToClient.close();
		this.inFromClient.close();
	}

}