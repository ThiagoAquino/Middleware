package middleware.message;

import java.io.Serializable;

public class Message implements Serializable {
	private MessageHeader header;
	private MessageBody body;


	public Message() {};

	public Message(MessageHeader messageHeader, MessageBody messageBody) {
		this.header = messageHeader;
		this.body = messageBody;
	}

	public MessageHeader getHeader() {
		return header;
	}

	public void setHeader(MessageHeader header) {
		this.header = header;
	}

	public MessageBody getBody() {
		return body;
	}

	public void setBody(MessageBody body) {
		this.body = body;
	}

}
