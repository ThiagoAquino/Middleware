package mw;

import java.util.ArrayList;

public class Invocation extends ClientProxy{

	private static final long serialVersionUID = 1L;
	private String ipAddress;
	private int portNumber;
	private int objectId;
	private String operationName;
	private ArrayList<Object> parameters;
	
	

    public ArrayList<Object> getParameters() {
		return parameters;
	}

	public String getOperationName() {
		return operationName;
	}

	public int getObjectId() {
		return objectId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public void setOperationName(String methodName) {
		this.operationName = methodName;
	}

	public void setParameters(ArrayList<Object> parameters) {
		// TODO Auto-generated method stub
		
	}
}
