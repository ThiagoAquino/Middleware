package middleware;

import java.io.IOException;

import middleware.ClientRequestHandler;
import middleware.message.Message2;

public class Requestor {
	public Object invoke(ClientProxy proxy, Message2 message) throws IOException, ClassNotFoundException {
		ClientRequestHandler crh = new ClientRequestHandler(proxy.getAor().getHost(), proxy.getAor().getPort());
		crh.create();
		byte[] marshalledMessage = Marshaller.marshall(message);
		crh.send(marshalledMessage);
		byte[] msgToBeUnmarshalled = crh.receive();
		crh.close();
		Message2 unmarshalledMessage = Marshaller.unmarshall(msgToBeUnmarshalled);
		return unmarshalledMessage.getResult();
	}
}
