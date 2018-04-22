package Message;

import java.io.Serializable;
import java.util.ArrayList;

public class RequestBody implements Serializable{
	private ArrayList<Object> parameters = new ArrayList<Object>();

	public RequestBody() {}

	public ArrayList<Object> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Object> parameters) {
		this.parameters = parameters;
	}

	
}
