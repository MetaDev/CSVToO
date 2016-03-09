package webcomm;

import gui.component.custom.OKNotificationWindow;
import gui.component.custom.PleaseWaitBackgroundProcess;
import gui.component.custom.WaitProcess;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.xml.ws.BindingProvider;

import model.AppConstants;

import webcomm.octws.Credentials;
import webcomm.octws.OctopusWS;
import webcomm.octws.OctopusWSService;

public class WSCommunicator {
	/*
	 * communication is in 2 steps login and execution of WSAcces should be done
	 * in different thread and show please wait window
	 */
	public static OctopusWS login() {
		try {
			String username = AppConstants.getUserName();
			String password = AppConstants.getPassWord();
			// Creer een nieuwe webservice object
			OctopusWS port = null;


			OctopusWSService ws;
			try {
				ws = new OctopusWSService(
						new URL("https://service.inaras.be/OctopusService01-13/OctopusWSService?wsdl"));
				port = ws.getOctopusWSPort();
			} catch (MalformedURLException e1) {
				return null;
			} catch (javax.xml.ws.WebServiceException e2) {
				OKNotificationWindow.openError("Something went wrong when trying to connect to webservice: "+e2.getMessage(),false);
				return null;
			}
			// Sta cookies toe
			((BindingProvider) port).getRequestContext().put(
					BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
			// Maak een nieuw credentials object voor het opslaan van naam en
			// paswoord.
			Credentials cred = new Credentials();
			cred.setUser(username);
			cred.setPassword(password);

			// Voer de authenicate method uit
			int returnValue = 0;
                        //authenticatie!!
                        String devauth="1213df3a-6aaf-42f0-af51-b5412579d743";
			returnValue = port.authenticate(devauth,cred);
			if (returnValue != 0) {
				OKNotificationWindow.openError("login failed because: "
						+ port.getErrorDescription(returnValue),false);
				return null;
			}
			return port;
		} catch (Exception e) {
			OKNotificationWindow.openError("An error occured: " + e.getMessage(),false);
			return null;
		}
	}

	public static OctopusWS loginWithAlert(JFrame parent) {
		WaitProcess process = new WaitProcess() {
			@Override
			public Object execute() {
				return WSCommunicator.login();
			}
		};
		// open dialog and execute process
		return (OctopusWS) new PleaseWaitBackgroundProcess().start(parent,
				"Please wait while the application tries to log in.", process);
	}

	public static void executeWithAlert(JFrame parent, OctopusWS port,
			WSAcces acces) {

		WaitProcess process = new WaitProcess(port, acces) {
			@Override
			public Object execute() {
				OctopusWS port = (OctopusWS) super.arg0;
				WSAcces acces = (WSAcces) super.arg1;
				WSCommunicator.execute(port, acces);
				return null;
			}
		};
		// open dialog and execute process
		new PleaseWaitBackgroundProcess().start(parent, acces.getMessage(),
				process);
	}

	public static void execute(OctopusWS port, WSAcces acces) {
		// open dossier
		port.connectToDossier(port.getDossiers().get(0).getDossierKey());
		// voer acces uit
		acces.execute(port);
		// sluit dossier
		port.closeDossier();
	}

	public static void loginAndExecuteWithAlert(JFrame parent, WSAcces acces) {

		WaitProcess process = new WaitProcess(acces) {
			@Override
			public Object execute() {
				OctopusWS port = WSCommunicator.login();
				WSAcces acces = (WSAcces) super.arg0;
				WSCommunicator.execute(port, acces);
				return null;
			}
		};
		// open dialog and execute process
		new PleaseWaitBackgroundProcess().start(parent, acces.getMessage(),
				process);
	}

	public static void loginAndExecute(WSAcces acces) {
		OctopusWS port = login();
		execute(port, acces);
	}

}
