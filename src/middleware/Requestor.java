package middleware;

import java.io.IOException;

import message.Message2;
import middleware.infrastructure.ClientRequestHandler;

public class Requestor {
	public Object invoke(ClientProxy cp, Message2 msg) throws IOException, ClassNotFoundException {
		byte[] marshalledMessage;
		byte[] msgToBeUnmarshalled;
		
		ClientRequestHandler crh = new ClientRequestHandler(cp.getAor().getHost(), cp.getAor().getPort());
		
		crh.create();
		
		marshalledMessage = Marshaller.marshall(msg);
		crh.send(marshalledMessage);
		
		msgToBeUnmarshalled = crh.receive();
		
		crh.close();
		
		Message2 unmarshalledMessage = Marshaller.unmarshall(msgToBeUnmarshalled);
		
		return unmarshalledMessage.getResult();
	}
}
