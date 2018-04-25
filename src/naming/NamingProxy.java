package naming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import message.Message;
import middleware.ClientProxy;
import middleware.ClientRequestHandler;
import middleware.Marshaller;

public class NamingProxy extends ClientProxy implements INaming {
	
	private String host;
	private int port;
	private ClientRequestHandler clientRequestHandler;

//	public NamingProxy() throws IOException {
//		this(2222, 2222);
//	}

	public NamingProxy(String host, int port) throws IOException {
		this.host = host;
		this.port = port;
		this.clientRequestHandler = new ClientRequestHandler(this.host, this.port);
	}

	@Override
	public void bind(String serviceName, ClientProxy clientProxy) throws IOException {
		List<Object> parameters = new ArrayList<>();
		parameters.add(serviceName);
		parameters.add(clientProxy);
		
		Message msg = new Message(); // parameters ?
		Marshaller marc = new Marshaller();
		byte[] messageMarshalled = marc.marshall(msg);
		this.clientRequestHandler.send(messageMarshalled);
	}

	@Override
	public ClientProxy lookUp(String serviceName) throws IOException, ClassNotFoundException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		List<Object> parameters = new ArrayList<>();
		parameters.add(serviceName);
		
		Message msg = new Message(); // parameters ?
		Marshaller marc = new Marshaller();
		byte[] messageMarshalled = marc.marshall(msg);
		this.clientRequestHandler.send(messageMarshalled);
		messageMarshalled = this.clientRequestHandler.receive();
		ClientProxy clientProxy = (ClientProxy) marc.unmarshall(messageMarshalled); // pegar o ClientProxy da msg
		return clientProxy;
	}
	
}
