package gui.window.config;

import gui.component.custom.RequestFocusListener;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.AppConstants;
import model.Settings;
import webcomm.WSACache1;
import webcomm.WSACache2;
import webcomm.WSCommunicator;

import webcomm.octws.OctopusWS;

public class LoginWindow extends JPanel {
	private JTextField userName;
	private JTextField passWord;

	public LoginWindow() {
		super();
		setLayout(new GridLayout(2, 2));
		// add 2 text fields
		add(new JLabel("Username"));
		userName = new JTextField();
		add(userName);
		add(new JLabel("Password"));
		passWord = new JTextField();
		RequestFocusListener.setComponentFocusOnOpen(passWord);
		add(passWord);
		// load username from preference
		if (Settings.getPreference("userName") != null) {
			userName.setText(Settings.getPreference("userName"));
		}

	}

	/*
	 * return true if login succesfull
	 */
	public boolean open(JFrame parent) {
		// first loop until login succeeded
		OctopusWS port = null;
		while (port == null) {
			int result = JOptionPane.showConfirmDialog(parent, this, "Login",
					JOptionPane.PLAIN_MESSAGE);
			// ok is pressed
			if (result == 0) {
				// save username and password in appConstants
				AppConstants.setUserName(userName.getText());
				AppConstants.setPassWord(passWord.getText());

				// save username in preference
				Settings.setPreference("userName", userName.getText());
				// try to log in with alert
				port = WSCommunicator.loginWithAlert(parent);
			}// if user closes the login window, close main window
			else if (result == JOptionPane.CLOSED_OPTION) {
				return false;
			}
		}
		// Once login succeeded open a window in which the user can select the
		// active book year and journal n

		// if valid login
		// cache data
		WSCommunicator.executeWithAlert(parent, port, WSACache1.getInstance());
		// show new window for the user to choose bookyear and journal
		// if the user doesn't choose a bookyear and journal close window
		if (!new ChooseBookYearJournalWindow().open(parent)) {
			return false;
		}
		//second round of caching after receiving necessary info
		WSCommunicator.executeWithAlert(parent, port, WSACache2.getInstance());
		
		return true;

	}

	
}
