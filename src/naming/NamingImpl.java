package naming;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import middleware.ClientProxy;

public class NamingImpl implements INaming {

	private Map<String, LinkedList<ClientProxy>> lookUpTable;

	public NamingImpl() {
		this.lookUpTable = new HashMap<String, LinkedList<ClientProxy>>();
	}

	@Override
	public void bind(String service, ClientProxy proxy) throws ClassNotFoundException, IOException {
		if (this.lookUpTable.containsKey(service)) {
			this.lookUpTable.get(service).addLast(proxy);
		} else {
			LinkedList<ClientProxy> newService = new LinkedList<ClientProxy>();
			newService.add(proxy);
			this.lookUpTable.put(service, newService);
		}
	}

	@Override
	public ClientProxy lookUp(String service) throws Exception {
		ClientProxy proxy = this.lookUpTable.get(service).getFirst();
		this.lookUpTable.get(service).removeFirst();
		this.lookUpTable.get(service).addLast(proxy);
		return proxy;
	}

}
