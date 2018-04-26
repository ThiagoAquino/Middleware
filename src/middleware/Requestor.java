package middleware;

import java.io.IOException;

import middleware.infrastructure.ClientRequestHandler;

public class Requestor {
	public Object invoke(ClientProxy cp, Message msg) throws IOException, ClassNotFoundException {
		ClientRequestHandler crh = new ClientRequestHandler(cp.getAor().getHost(), cp.getAor().getPort());
		crh.create();
		
		byte[] marshalledMessage = Marshaller.marshall(msg);
		crh.send(marshalledMessage);
		byte[] msgToBeUnmarshalled = crh.receive();
		crh.close();
		Message unmarshalledMessage = Marshaller.unmarshall(msgToBeUnmarshalled);
		return unmarshalledMessage.getResult();
	}
}
