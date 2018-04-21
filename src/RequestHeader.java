import java.io.Serializable;

public class RequestHeader implements Serializable {

	private String context;
	private int requestId;
	private boolean responseExpexted;
	private int objetKey;
	private String operation;
	
	
	public RequestHeader() {}
	
	
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public boolean isResponseExpexted() {
		return responseExpexted;
	}
	public void setResponseExpexted(boolean responseExpexted) {
		this.responseExpexted = responseExpexted;
	}
	public int getObjetKey() {
		return objetKey;
	}
	public void setObjetKey(int objetKey) {
		this.objetKey = objetKey;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	
	
			
}
