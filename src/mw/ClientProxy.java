package mw;
import java.io.Serializable;
import org.omg.CORBA.portable.UnknownException;

public class ClientProxy implements Serializable {

	private static final long serialVersionUID = 1L;
	public String host;
	public int port;
	public int objectId;


	public ClientProxy() {}
	public ClientProxy(final int p) throws UnknownException {}


	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getObjectId() {
		return objectId;
	}
	
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

}
