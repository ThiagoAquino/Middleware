package mw;

import Message.Message;

public class ControleProxy extends ClientProxy implements IControle {
	
	private String ip;
	private int port;
	
	public ControleProxy(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public int up(int vol) {
		
        Resquestor req = new Resquestor();
        Message msg = new Message();

        //Executar um serviço
        //Passar o vol pela msg + tipo do serviço que no caso é aumentar
        //E receber de volta o volume novo para retornar
        //inv: this.ip, this.port + msg
        
        Message rMsg = req.invoke(inv);           

		int nVol = rMsg.
		
		return nVol;
	}

	@Override
	public int down(int vol) {
		return vol--;
	}

	@Override
	public int nextChannel(int channel) {
		return channel++;
	}

	@Override
	public int previousChannel(int channel) {
		return channel--;
	}

//	@Override
//	public int changeChannel(int channel) {
//		return null;
//	}

}
