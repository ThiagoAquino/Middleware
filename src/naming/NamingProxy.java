package naming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import middleware.ClientProxy;
import middleware.Marshaller;
import middleware.message.Message2;
import middleware.ClientRequestHandler;

public class NamingProxy implements INaming {
	
	private String host;
	private int port;
	private ClientRequestHandler clientRequestHandler;

	public NamingProxy(String host, int port) throws IOException {
		this.host = host;
		this.port = port;
		this.clientRequestHandler = new ClientRequestHandler(this.host, this.port);
	}

	@Override
	public void bind(String serviceName, ClientProxy clientProxy) throws IOException {
		this.clientRequestHandler.create();
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		List<Object> parameters = new ArrayList<>();
		parameters.add(serviceName);
		parameters.add(clientProxy);

		Message2 message = new Message2(methodName, parameters);
		byte[] messageMarshalled = Marshaller.marshall(message);
		this.clientRequestHandler.send(messageMarshalled);
		this.clientRequestHandler.close();
	}

	@Override
	public ClientProxy lookUp(String serviceName) throws IOException, ClassNotFoundException {
		this.clientRequestHandler.create();
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		List<Object> parameters = new ArrayList<>();
		parameters.add(serviceName);

		Message2 message = new Message2(methodName, parameters);
		byte[] messageMarshalled = Marshaller.marshall(message);
		this.clientRequestHandler.send(messageMarshalled);
		messageMarshalled = this.clientRequestHandler.receive();
		this.clientRequestHandler.close();
		ClientProxy clientProxy = (ClientProxy) Marshaller.unmarshall(messageMarshalled).getResult();
		return clientProxy;
	}

}