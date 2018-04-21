
import java.io.Serializable;

public class ReplyBody implements Serializable {
	private Object operationResult;
	
	public ReplyBody() {}

	public Object getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(Object operationResult) {
		this.operationResult = operationResult;
	}
	
	
}
