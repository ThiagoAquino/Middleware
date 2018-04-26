package middleware;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import message.Message;

public class ServerRequestHandler {

	private int portNumber;
	private ServerSocket serverSocket;
	private Socket clientSocket;

	ObjectOutputStream outToClient = null;
	ObjectInputStream inFromClient = null;

	public ServerRequestHandler(int port) throws IOException {
		this.portNumber = port;
		serverSocket = new ServerSocket(portNumber);
		clientSocket = serverSocket.accept();
	}

	public void send(byte [] msg) throws IOException {
		outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
		outToClient.writeObject(msg);

	}

	public byte [] receive()  throws IOException, InterruptedException, ClassNotFoundException {
		inFromClient = new ObjectInputStream(clientSocket.getInputStream());
		//Message retorno = (Message) inFromClient.readObject();
		return (byte[]) inFromClient.readObject();
	}

}