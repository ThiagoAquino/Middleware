package application.remotecontrol;

import java.io.IOException;

import middleware.Invoker;
import middleware.Marshaller;
import middleware.ServerRequestHandler;
import middleware.message.Message2;

public class ControleInvoker extends Invoker {
	public void invoke(int port) throws IOException, Throwable {
//		ServerRequestHandler srh = new ServerRequestHandler(clientProxy.getAor().getPort());
		ServerRequestHandler srh = new ServerRequestHandler(port);

//		byte[] msgToBeUnmarshalled = null;
//		byte[] msgMarshalled = null;
//		Message msgUnmarshalled;
//		Marshaller mrsh = new Marshaller();
//		Termination ter = new Termination();
//
//		//Falta implementar
//		//Criar o objeto remoto
//		ControleImpl rObj = new ControleImpl();

		while(true) {
//			//receive message
//			msgToBeUnmarshalled = srh.receive();
//			//Unmarshall received message
//			msgUnmarshalled = mrsh.unmarshall(msgToBeUnmarshalled);
			srh.create();
			byte[] messageToBeUnmarshalled = srh.receive();
			Message2 messageUnmarshalled = Marshaller.unmarshall(messageToBeUnmarshalled);
			String method = messageUnmarshalled.getMethod();
			ControleImpl impl = (ControleImpl) this.lookUp(messageUnmarshalled.getObjectId());


			switch (method) {
			//Mudar Canal
			case "changeChannel":
				int qtd = (int) messageUnmarshalled.getParameters().get(0);
				messageUnmarshalled.setResult(impl.changeChannel(qtd));
				byte[] messageMarshalled = Marshaller.marshall(messageUnmarshalled);

				srh.send(messageMarshalled);
				break;

				//Mudar Volume
//			case "changeLevel":
//				int qtd1 = (int) msgUnmarshalled.getBody().getRequestBody().getParameters().get(0);
//				ter.setResult(rObj.changeLevel(qtd1));
//				Message changedLevel = new Message(new MessageHeader("protocolo", 0 ,false,0,0), new MessageBody(null, null, new ReplyHeader("",0 ,0), new ReplyBody(ter.getResult())));
//
//				msgMarshalled = mrsh.marshall(changedLevel);
//				srh.send(msgMarshalled);				
//				break;
			default:
				System.out.println("Case not expected in Invoker");
				break;
			}

		}
	}
}
