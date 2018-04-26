package application.remotecontrol;

import java.io.Serializable;
import java.util.ArrayList;

import middleware.ClientProxy;
import middleware.Invocation;
import middleware.Requestor;
import middleware.Termination;
import middleware.message.Message2;

public class ControleProxy extends ClientProxy implements IControle, Serializable {

	private String ip;
	private int port;
	

	public ControleProxy(String host, int port, int objectId) {
		super(host, port, objectId);
	}

	@Override
	public String changeChannel(int channel) throws Throwable {
//		Invocation inv = new Invocation();
		Termination ter = new Termination();
		ArrayList<Object> parameters = new ArrayList<Object>();
		class Local {};
		String methodName = null;
		Requestor requestor = new Requestor();
		
		methodName = Local.class.getEnclosingMethod().getName();
		parameters.add(channel);
		Message2 message = new Message2(this.getAor().getObjectId(), methodName, parameters);

		//information sent to requestor
//		inv.setObjectId(this.getAor().getObjectId());
//		inv.setIpAddress(this.getAor().getHost());
//		inv.setPortNumber(this.getAor().getPort());
//		inv.setOperationName(methodName);
//		inv.setParameters(parameters);
		
//		// invoke Requestor
//		ter = (Termination) requestor.invoke(inv);

		// result sent back to Client
//		return (String) ter.getResult();
		return requestor.invoke(this, message).toString();
	}


	@Override
	public String changeLevel(int level) throws Throwable {
//		Invocation inv = new Invocation();
		Termination ter = new Termination();
		ArrayList<Object> parameters = new ArrayList<Object>();
		class Local {};
		String methodName = null;
		Requestor requestor = new Requestor();
		Message2 message = new Message2(this.getAor().getObjectId(), methodName, parameters);

		methodName = Local.class.getEnclosingMethod().getName();
		parameters.add(level);
		
//		//information sent to requestor
//		inv.setObjectId(this.getObjectId());
//		inv.setIpAddress(this.getHost());
//		inv.setPortNumber(this.getPort());
//		inv.setOperationName(methodName);
//		inv.setParameters(parameters);
//		
//		// invoke Requestor
//		ter = requestor.invoke(inv);
		
		return requestor.invoke(this, message).toString();
	}

}
