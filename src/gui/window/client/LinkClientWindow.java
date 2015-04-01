package gui.window.client;

import gui.component.custom.EditClientButton;
import gui.component.custom.OKNotificationWindow;
import gui.component.custom.RequestFocusListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.ConflictTabelModel;
import salestoaccountinglogic.SToABooking.BookingLineFields;
import salestoaccountinglogic.SToAClient;

import webcomm.octws.RelationServiceData;

/*
 * panel that show, in a clear way, all cached clients
 * that can be used to link with the import client
 */
public class LinkClientWindow extends JPanel {

	private Map<String, RelationServiceData> sortedClientMapping;

	/*
	 * when opening Open a dialog box with a combobox showing clients by name
	 * and an edit button to open an edit client window
	 */
	public void open(JFrame parent, int row, int column,
			Collection<RelationServiceData> clients, ConflictTabelModel model) {
		if (clients.isEmpty()) {
			OKNotificationWindow.openError("No clients found.");
			return;
		}

		// build edit button
		final EditClientButton edit = new EditClientButton(parent);
		
		// build combobox
		Map<String, RelationServiceData> clientMapping = new HashMap<>();
		// get all clients
		for (RelationServiceData client : clients) {
			clientMapping.put(client.getName(), client);
		}
		sortedClientMapping = new TreeMap<>(new Comparator<String>() {
		    public int compare(String o1, String o2) {
		        return o1.toLowerCase().compareTo(o2.toLowerCase());
		    }
		});
		sortedClientMapping.putAll(clientMapping);
		Object[] sortedNames = sortedClientMapping.keySet().toArray();
		JComboBox<Object> comboBox = new JComboBox<>(sortedNames);
		RequestFocusListener.setComponentFocusOnOpen(comboBox);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					edit.setSelectedClient(sortedClientMapping
							.get((String)e.getItem()));
				}
			}
		});
		add(comboBox);
		// select client for editing
		RelationServiceData selectedOctClient = sortedClientMapping
				.get(sortedNames[comboBox.getSelectedIndex()]);
		//set default selected client
		edit.setSelectedClient(selectedOctClient);
		add(edit);
		int result = JOptionPane.showConfirmDialog(null, this,
				"Please choose a client.", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			// if selection changed
			selectedOctClient = sortedClientMapping.get(sortedNames[comboBox
					.getSelectedIndex()]);
			// if client not valid
			if (!SToAClient.clientIsValid(selectedOctClient)) {
				OKNotificationWindow.openError("One or more fields for client are invalid.");
				return;
			}
			// add new ID mapping to config mapping file
			// and to current client mapping
			String importClientID = model.getRows().get(row)
					.getBookingLineField(BookingLineFields.KlantID);
			SToAClient.addNewClientMapping(importClientID, selectedOctClient);

			// update table with new mapping
			model.updateClientMapping();
			
		}
	}
}
