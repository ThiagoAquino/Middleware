package mw;

import java.io.IOException;

import Message.*;

public class Invoker {

	public void invoke(ClientProxy clientProxy) throws IOException, Throwable {
		ServerRequestHandler srh = new ServerRequestHandler(clientProxy.getPort());

		byte[] msgToBeUnmarshalled = null;
		byte[] msgMarshalled = null;
		Message msgUnmarshalled = new Message();
		Marshaller mrsh = new Marshaller();
		Termination ter = new Termination();

		//Falta implementar
		//Criar o objeto remoto
		ControleImpl rObj = new ControleImpl();

		while(true) {
			//receive message
			msgToBeUnmarshalled = srh.receive();
			//Unmarshall received message
			msgUnmarshalled = mrsh.unmarshall(msgToBeUnmarshalled);

			switch (msgUnmarshalled.getBody().getRequestHeader().getOperation()) {
			//Mudar Canal
			case "changeChannel":
				int qtd = (int) msgUnmarshalled.getBody().getRequestBody().getParameters().get(0);
				ter.setResult(rObj.changeChannel(qtd));
				Message changedChannel = new Message(new MessageHeader("protocolo", 0 ,false,0,0), new MessageBody(null, null, new ReplyHeader("",0 ,0), new ReplyBody(ter.getResult())));

				msgMarshalled = mrsh.marshall(changedChannel);
				srh.send(msgMarshalled);

				break;

				//Mudar Volume
			case "changeLevel":
				int qtd1 = (int) msgUnmarshalled.getBody().getRequestBody().getParameters().get(0);
				ter.setResult(rObj.changeLevel(qtd1));
				Message changedLevel = new Message(new MessageHeader("protocolo", 0 ,false,0,0), new MessageBody(null, null, new ReplyHeader("",0 ,0), new ReplyBody(ter.getResult())));

				msgMarshalled = mrsh.marshall(changedLevel);
				srh.send(msgMarshalled);				
				break;
			default:
				System.out.println("Case not expected in Invoker");
				break;
			}

		}
	}
}
