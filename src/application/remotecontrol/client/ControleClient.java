package application.remotecontrol.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import application.remotecontrol.ControleProxy;
import naming.NamingProxy;

public class ControleClient {

	private static final Logger LOGGER = Logger.getLogger(ControleClient.class.getName());
	
	private static final String HOST = "localhost";
	private static final int NAMINGPORT = 2224;
	private static final String SERVICE = "Remote Control";

	public static void main(String[] args) throws Throwable {
		
		NamingProxy namingProxy = new NamingProxy(HOST, NAMINGPORT);

		ControleProxy controleProxy = (ControleProxy) namingProxy.lookUp(SERVICE);

		LOGGER.log(Level.INFO, controleProxy.changeChannel(10));
	}

}
