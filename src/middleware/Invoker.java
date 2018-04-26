package middleware;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
	private Map<Integer, Object> LookUpTable;

	public Invoker() {
		this.LookUpTable = new HashMap<>();
	}

	public void bind(Integer id, Object value) {
		this.LookUpTable.put(id, value);
	}

	public Object lookUp(Integer id) throws Exception {
		Object object = this.LookUpTable.get(id);
		if (object == null) {
			throw new Exception();
		}
		return object;
	}
}