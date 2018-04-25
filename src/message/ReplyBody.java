package message;

import java.io.Serializable;

public class ReplyBody implements Serializable {

	private Object operationResult;

	public ReplyBody(Object result) {
		this.operationResult = result;
	}

	public Object getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(Object operationResult) {
		this.operationResult = operationResult;
	}

}
