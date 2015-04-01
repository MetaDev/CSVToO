package gui.component.custom;


public abstract class WaitProcess {
	// an interface which is used to execute time consuming process' and urge the user to wait
	protected Object arg0;
	protected Object arg1;
	
	public WaitProcess(Object arg0, Object arg1) {
		this.arg0 = arg0;
		this.arg1 = arg1;
	}
	public WaitProcess(Object arg0) {
		this.arg0 = arg0;
	}

	public WaitProcess() {
	}

	public Object execute() {
		return null;
	}

}
