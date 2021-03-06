package naming;

import middleware.ClientProxy;
import middleware.Marshaller;
import middleware.ServerRequestHandler;
import middleware.message.Message2;

public class NamingInvoker {
	public void invoke(int port) throws Exception {

		ServerRequestHandler srh = new ServerRequestHandler(port);
		NamingImpl impl = new NamingImpl();

		while (true) {

			srh.create();
			byte[] messageToBeUnmarshalled = srh.receive();
			Message2 messageUnmarshalled = Marshaller.unmarshall(messageToBeUnmarshalled);
			String methodName = messageUnmarshalled.getMethod();
			String serviceName = null;
			ClientProxy clientProxy = null;

			switch (methodName) {
			case "bind":
				serviceName = (String) messageUnmarshalled.getParameters().get(0);
				clientProxy = (ClientProxy) messageUnmarshalled.getParameters().get(1);
				impl.bind(serviceName, clientProxy);
				break;
			case "lookUp":
				serviceName = (String) messageUnmarshalled.getParameters().get(0);
				clientProxy = impl.lookUp(serviceName);
				messageUnmarshalled.setResult(clientProxy);
				byte[] messageMarshalled = Marshaller.marshall(messageUnmarshalled);
				srh.send(messageMarshalled);
				break;
			default:
				System.out.println("Case not expected in NamingInvoker");
				break;
			}
		}
	}
}
