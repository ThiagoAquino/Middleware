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
	public void bind(String service, ClientProxy cp) throws ClassNotFoundException, IOException {
		if (this.lookUpTable.containsKey(service)) {
			this.lookUpTable.get(service).addLast(cp);
		} else {
			LinkedList<ClientProxy> newService = new LinkedList<ClientProxy>();
			newService.add(cp);
			this.lookUpTable.put(service, newService);
		}
	}

	@Override
	public ClientProxy lookUp(String service) throws Exception {
		LinkedList<ClientProxy> list = this.lookUpTable.get(service);

		if (list == null) {
			throw new Exception();
		}

		ClientProxy cp = this.lookUpTable.get(service).getFirst();
		this.lookUpTable.get(service).removeFirst();
		this.lookUpTable.get(service).addLast(cp);

		return cp;
	}
	
}
