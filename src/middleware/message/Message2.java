package middleware.message;

import java.io.Serializable;
import java.util.List;

public class Message2 implements Serializable {
	
	private static final long serialVersionUID = 666666L;

	private int objectId;
	private String method;
	private List<Object> parameters;
	private Object result;

	
	public Message2(int objectId, String HeaderMethod, List<Object> BodyParameters) {
		this.objectId = objectId;
		this.method = HeaderMethod;
		this.parameters = BodyParameters;
	}

	public Message2(String HeaderMethod, List<Object> BodyParameters) {
		this.method = HeaderMethod;
		this.parameters = BodyParameters;
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
