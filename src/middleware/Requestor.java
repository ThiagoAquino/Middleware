package middleware;

import java.io.IOException;

import middleware.infrastructure.ClientRequestHandler;

public class Requestor {
	public Object invoke(ClientProxy cp, Message msg) throws IOException, ClassNotFoundException {
		byte[] marshalledMessage;
		byte[] msgToBeUnmarshalled;
		
		ClientRequestHandler crh = new ClientRequestHandler(cp.getAor().getHost(), cp.getAor().getPort());
		
		crh.create();
		
		marshalledMessage = Marshaller.marshall(msg);
		crh.send(marshalledMessage);
		
		msgToBeUnmarshalled = crh.receive();
		
		crh.close();
		
		Message unmarshalledMessage = Marshaller.unmarshall(msgToBeUnmarshalled);
		
		return unmarshalledMessage.getResult();
	}
}
