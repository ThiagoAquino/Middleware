package middleware;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import middleware.message.Message2;

public class Marshaller {
	public static byte[] marshall(Message2 message) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
		objectStream.writeObject(message);

		return byteStream.toByteArray();
	}

	public static Message2 unmarshall(byte[] message) throws IOException, ClassNotFoundException {
		ByteArrayInputStream byteStream = new ByteArrayInputStream(message);
		ObjectInputStream objectStream = new ObjectInputStream(byteStream);

		return (Message2) objectStream.readObject();
	}
}
