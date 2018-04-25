package middleware;

import java.io.Serializable;

public class AbsoluteObjectReference implements Serializable {

	private static final long serialVersionUID = 1L;
	public String host;
	public int port;
	public int objectId;

	public AbsoluteObjectReference(String host, int port, int objectId) {
		this.host = host;
		this.port = port;
		this.objectId = objectId;
	}

	public String getHost() {
		return host;
	}

	public int getObjectId() {
		return objectId;
	}

	public int getPort() {
		return port;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
