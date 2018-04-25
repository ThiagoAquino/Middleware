package middleware;
import java.io.Serializable;
import org.omg.CORBA.portable.UnknownException;

public class ClientProxy implements Serializable {

	private static final long serialVersionUID = 1L;

	public String host;
	public int port;
	public int objectId;

	private AbsoluteObjectReference aor;

	public ClientProxy(String host, int port, int objectId) {
		this.aor = new AbsoluteObjectReference(host, port, objectId);
	}
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

	public AbsoluteObjectReference getAor() {
		return aor;
	}

	public void setAor(AbsoluteObjectReference aor) {
		this.aor = aor;
	}
	
}
