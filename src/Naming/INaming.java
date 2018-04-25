package Naming;

import java.io.IOException;

import mw.ClientProxy;

public interface INaming {
	
	public void bind(String service, ClientProxy clientProxy) throws ClassNotFoundException, IOException;

	public ClientProxy lookUp(String service) throws ClassNotFoundException, IOException, Exception;

}
