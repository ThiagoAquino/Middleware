package mw;

import Message.Message;

public class ServidorNomesProxy extends ClientProxy {

	private String host;
	private int port;

	public ServidorNomesProxy(String Host, int Porta)  {
		this.host = Host;
		this.port = Porta;
	}

	public ClientProxy Lookup (String serviceName) {
		Message msg = new Message();

		Marshaller marc = new Marshaller();
		ClientRequestHandler crh = new ClientRequestHandler(this.host, this.port);

		//setar o cabeçalho e o serviceName em msg		

		crh.send(marc.marshall(msg));

		Message msgReceive = (Message) marc.unmarshall(crh.receive());

		//crh.closeConnection();

		//pegar os parametros necessarios para retornar um Controle
		//String ip = (String) msgReceive.
		//int port = (int) msgReceive.

		return new ControleProxy(ip, port);

	}
}