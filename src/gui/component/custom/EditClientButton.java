package gui.component.custom;

import gui.window.client.EditClientWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import webcomm.octws.RelationServiceData;

public class EditClientButton extends JButton implements ActionListener {
	private RelationServiceData selectedClient;
	private JFrame parent;

	public EditClientButton(JFrame parent) {
		super("Edit Client");
		this.parent = parent;

		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new EditClientWindow().open(parent, selectedClient);
	}

	public void setSelectedClient(RelationServiceData selectedClient) {
		this.selectedClient = selectedClient;
	}

}
