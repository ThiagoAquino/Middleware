import java.net.UnknownHostException;

public class Resquestor {

	public Termination invoke(Invocation inv) throws UnknownHostException. IOException, Throwable {
		ClientRequestHandler crh = new ClienteRequesthandler(inv.getClientProxy().getHost(),inv.getClientProxy().getPort());

	Marshaller marshaller = new Marshaller();
	Termination termination = new Termination();
	byte [] msgMarshalled;
	byte [] msgToBeUnmarshalled;
	Message msgUnmarshalled = new Message();
	
	//map invocation into a message
	
	RequestHeader requestHeader = new RequestHeader("", 0, true, 0, inv.getOperationName());
	RequestBody requestBody = new RequestBody(inv.getParameters());
	MessageHeader messageHeader = new MessageHeader("MIOP", 0, false, 0, 0);
	MessageBody messageBody =  new MessageBody(requestHeader, requestBody, null, null);
	Message msgToBeMarshalled = new Message(messageHeader, messageBody);		
	
	//mashall request message
	msgMarshalled = marshaller.marshall(msgToBeMarshalled);
	
	//send marshalled message
	crh.send(msgMarshalled);
	
	//receive reply message
	msgToBeUnmarshalled = crh.receive();
	
	// unmarshall replay message
	msgUnmarshalled = marshaller.unmarshall(msgToBeUnmarshalled);
	
	//return result to Client Proxy
	termination.setResult(msgUnmarshalled.getBody().getReplyBody().getOperationResult());
	
	}

}
