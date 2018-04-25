package mw;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ControleProxy extends ClientProxy implements IControle {
	
	private String ip;
	private int port;
	
	public ControleProxy(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public String changeChannel(int channel) throws Throwable {
		Invocation inv = new Invocation();
		Termination ter = new Termination();
		ArrayList<Object> parameters = new ArrayList<Object>();
		class Local {};
		String methodName = null;
		Requestor requestor = new Requestor();
		
		methodName = Local.class.getEnclosingMethod().getName();
		parameters.add(channel);
		
		//information sent to requestor
		inv.setObjectId(this.getObjectId());
		inv.setIpAddress(this.getHost());
		inv.setPortNumber(this.getPort());
		inv.setOperationName(methodName);
		inv.setParameters(parameters);
		
		// invoke Requestor
		ter = requestor.invoke(inv);
		
		// result sent back to Client
		return (String) ter.getResult();
	}

	@Override
	public String changeLevel(int level) throws Throwable {
		Invocation inv = new Invocation();
		Termination ter = new Termination();
		ArrayList<Object> parameters = new ArrayList<Object>();
		class Local {};
		String methodName = null;
		Requestor requestor = new Requestor();
		
		methodName = Local.class.getEnclosingMethod().getName();
		parameters.add(level);
		
		//information sent to requestor
		inv.setObjectId(this.getObjectId());
		inv.setIpAddress(this.getHost());
		inv.setPortNumber(this.getPort());
		inv.setOperationName(methodName);
		inv.setParameters(parameters);
		
		// invoke Requestor
		ter = requestor.invoke(inv);
		
		return (String) ter.getResult();
	}

}
