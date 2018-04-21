import java.io.Serializable;

public class MessageBody implements Serializable {

	private RequestHeader requestHeader;
	private RequestBody requestBody;
	private ReplyHeader replyHeader;
	private ReplyBody replyboy;
	
	
	
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}
	public RequestBody getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(RequestBody requestBody) {
		this.requestBody = requestBody;
	}
	public ReplyHeader getReplyHeader() {
		return replyHeader;
	}
	public void setReplyHeader(ReplyHeader replyHeader) {
		this.replyHeader = replyHeader;
	}
	public ReplyBody getReplyboy() {
		return replyboy;
	}
	public void setReplyboy(ReplyBody replyboy) {
		this.replyboy = replyboy;
	}
	
}
