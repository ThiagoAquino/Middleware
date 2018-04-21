import java.net.UnknownHostException;

public class Resquestor {

	public Termination invoke(Invocation inv) throws UnknownHostException. IOException, Throwable {
		ClientRequestHandler crh = new ClienteRequesthandler(inv.getClientProxy().getHost(),inv.getClientProxy().getPort());

	Marshaller marshaller = new Marshaller();
	Termination termination = new Termination();
	byte [] msgMarshalled;
	byte [] msgToBeUnmarshalled;
	Message msgUnmarshalled = new Message();
	
	
	}

}
