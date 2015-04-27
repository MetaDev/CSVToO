package webcomm;

import webcomm.octws.OctopusWS;

public abstract class WSAcces {
	
	private String message;
	public WSAcces(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void execute(OctopusWS webService){};

	public static WSAcces getInstance() {
		return null;
	};
}
