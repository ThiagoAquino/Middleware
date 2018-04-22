
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
		//TvImpl rObj = new TvImpl();

		while(true) {
			//receive message
			msgToBeUnmarshalled = srh.receive();
			//Unmarshall received message
			msgUnmarshalled = mrsh.unmarshall(msgToBeUnmarshalled);
			
			switch (msgUnmarshalled.getBody().getRequestHeader().getOperation()) {
			//Mudar Canal
			case "MC":
					int qtd = (int) msgUnmarshalled.getBody().getRequestBody().getParameters().get(0);
					ter.result(rObj.MC(qtd));
					Message ChangedChannel = new Message(new MessageHeader("protocolo", 0 ,false,0,0), new MessageBody(null, null, new ReplyHeader("",0 ,0), new ReplyBody(ter.getResult())));
					
					msgMarshalled = mrsh.marshall(ChangedChannel);
					srh.send(msgMarshalled);
					
					break;
					
			//Mudar Volume
			case "MV":
				int qtd1 = (int) msgUnmarshalled.getBody().getRequestBody().getParameters().get(0);
				ter.result(rObj.MV(qtd1));
				Message ChangedVolume = new Message(new MessageHeader("protocolo", 0 ,false,0,0), new MessageBody(null, null, new ReplyHeader("",0 ,0), new ReplyBody(ter.getResult())));
				
				msgMarshalled = mrsh.marshall(ChangedVolume);
				srh.send(msgMarshalled);				
				break;
			}




		}
	}
}
