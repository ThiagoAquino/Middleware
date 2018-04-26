package application.remotecontrol.server;

import application.remotecontrol.ControleImpl;
import application.remotecontrol.ControleInvoker;
import application.remotecontrol.ControleProxy;
import naming.NamingProxy;

public class ControleServer {
	
	private static final String HOST = "localhost";
	private static final int PORT = 2222;
	private static final String SERVICE = "Remote Control";
	private static final int NAMINGPORT = 2224;

	public static void main(String[] args) throws Throwable {

		ControleInvoker invoker = new ControleInvoker();

		// create remote object
		ControleImpl impl = new ControleImpl();

		// obtain instance of Naming Service
		NamingProxy namingProxy = new NamingProxy(HOST, NAMINGPORT);

		invoker.bind(impl.hashCode(), impl);
		ControleProxy cp = new ControleProxy(HOST, PORT, impl.hashCode());
		namingProxy.bind(SERVICE, cp);

		// invoke Invoker
		invoker.invoke(PORT);
	}
}
