package application;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.omg.CORBA.portable.UnknownException;

import middleware.ClientProxy;
import middleware.Invocation;
import middleware.Requestor;
import middleware.Termination;

public class ControleProxy extends ClientProxy implements IControle {
	
	private String ip;
	private int port;
	
	
	public ControleProxy(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public ControleProxy(int p) throws UnknownException {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public ControleProxy(String host, int port, int objectId) {
		super(host, port, objectId);
		// TODO Auto-generated constructor stub
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
