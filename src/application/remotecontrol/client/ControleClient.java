package application.remotecontrol.client;

import application.remotecontrol.ControleProxy;
import naming.NamingProxy;

public class ControleClient {

	private static final String HOST = "localhost";
	private static final int NAMINGPORT = 2224;
	private static final String SERVICE = "Remote Control";

	public static void main(String[] args) throws Throwable {
		
		NamingProxy namingProxy = new NamingProxy(HOST, NAMINGPORT);

		ControleProxy controleProxy = (ControleProxy) namingProxy.lookUp(SERVICE);

		System.out.println(controleProxy.changeChannel(10));
	}

}
