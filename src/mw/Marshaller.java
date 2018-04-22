package mw;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Message.Message;

public class Marshaller {
	
	public byte[] marshall(Message msgToBeMarshalled) throws IOException, InterruptedException{
		
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
		objectStream.writeObject(msgToBeMarshalled);
		
		return byteStream.toByteArray();
	}
	
	public Message unmarshall(byte [] msgToBeUnmarshalled) throws IOException, InterruptedException, ClassNotFoundException {
		
		ByteArrayInputStream byteStream = new ByteArrayInputStream(msgToBeUnmarshalled);
		ObjectInputStream objectStream = new ObjectInputStream(byteStream);
		Object retorno = objectStream.readObject();
		
		return (Message) retorno;
	}
}
