package middleware;

import java.io.Serializable;

public class ClientProxy implements Serializable {

	private static final long serialVersionUID = 100L;

	private AbsoluteObjectReference aor;

	public ClientProxy(String host, int port, int objectId) {
		this.aor = new AbsoluteObjectReference(host, port, objectId);
	}

	public AbsoluteObjectReference getAor() {
		return aor;
	}

	public void setAor(AbsoluteObjectReference aor) {
		this.aor = aor;
	}

}
