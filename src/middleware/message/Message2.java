package middleware.message;

import java.io.Serializable;
import java.util.List;

public class Message2 implements Serializable {
	private static final long serialVersionUID = 5232674033479375617L;

	private int objectId;
	private String method;
	private List<Object> parameters;
	private Object result;

	public Message2(int objectId, String method, List<Object> parameters) {
		this.objectId = objectId;
		this.method = method;
		this.parameters = parameters;
	}

	public Message2(String method, List<Object> parameters) {
		this.method = method;
		this.parameters = parameters;
	}

	public String getMethod() {
		return method;
	}

	public int getObjectId() {
		return objectId;
	}

	public List<Object> getParameters() {
		return parameters;
	}

	public Object getResult() {
		return result;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
