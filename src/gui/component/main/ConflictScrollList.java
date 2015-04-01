package gui.component.main;

import gui.component.custom.ConflictTableComboBoxCellEditor;
import gui.component.custom.OKCancelNotificationWindow;
import gui.window.client.EditClientWindow;
import gui.window.client.LinkClientWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import model.CacheModel;
import model.ConflictTabelModel;
import salestoaccountinglogic.SToABooking;
import salestoaccountinglogic.SToABooking.BookingLineFields;
import salestoaccountinglogic.SToAClient;

/*
 * A scroll tabel gui element
 * Containing all unresolved conflicts
 */
@SuppressWarnings("serial")
public class ConflictScrollList extends JPanel {
	// Instance attributes used in this example
	private JTable table;
	private JScrollPane scrollPane;
	private ConflictTabelModel model;

	// Constructor of main frame
	public ConflictScrollList(JFrame parent, String columnNames[]) {

		// Set the frame characteristics
		setBackground(Color.gray);

		// Create a panel to hold all other components
		setLayout(new BorderLayout());
		// create a model instance and fill it
		model = new ConflictTabelModel(columnNames);
		// Create a new table instance
		table = new JTable(model);
		// Configure some of JTable's paramters
		table.setDefaultRenderer(Object.class, new MyRenderer());

		table.setShowHorizontalLines(true);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Change the selection colour
		table.setSelectionForeground(Color.white);
		table.setSelectionBackground(Color.gray);
		// add mouse listener to open new client dialog box when external id is
		// clicked
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JTable table = (JTable) e.getSource();
				JFrame parent = (JFrame) SwingUtilities.getRoot(table);
				ConflictTabelModel model = (ConflictTabelModel) table
						.getModel();
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				// if in external ID column
				if (column == BookingLineFields.OctopusClient.ordinal()) {

					
					// Custom button text
					Object[] options = { "Previously Existing", "Recently Edited", "Create New" };
					int n = JOptionPane.showOptionDialog(null,
							"Link with existing or new client?",
							"Choose a client.",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					// Existing
					if (n == 0) {
						// open existing client window
						new LinkClientWindow().open(parent, row, column,
								CacheModel.getClients(), model);
					}
					// Recently linked
					else if (n == 1) {
						// open client window with all recently added clients
						new LinkClientWindow().open(parent, row, column,
								SToAClient.getNewOrEditedClients(), model);
					}
					// New
					else if (n == 2) {
						// new client already exists
						if(SToAClient.getClientByVATNr(model.getRows()
								.get(row)
								.getBookingLineField(BookingLineFields.BTWNummer))!=null){

							//alert user of duplicate vat number
							if (!OKCancelNotificationWindow
									.open("A client whit this VAT number already exists, if you want to link with it,"
											+ " choose from RECENTLY LINKED or PREVIOUSLY EXISTING.\n"
											+ "Do you wish to continue?")){
								return;
							}
								
						}
						// open a client edit window filled with row info
						new EditClientWindow().open(parent, row, column, model);
					}
				}
			}
		});
		// add combobox for VAT code and Booking Account Key
		TableColumn vatCodeColumn = table.getColumnModel().getColumn(
				BookingLineFields.BTWCode.ordinal());
		vatCodeColumn.setCellEditor(new ConflictTableComboBoxCellEditor(
				CacheModel.getVatCodes().keySet().toArray(new String[] {})));
		TableColumn bookingAccountColumn = table.getColumnModel().getColumn(
				BookingLineFields.BookingAccountKey.ordinal());
		bookingAccountColumn.setCellEditor(new ConflictTableComboBoxCellEditor(
				CacheModel.getSalesBookingAccounts().keySet()
						.toArray(new String[] {})));
		// set editor on single click
		DefaultCellEditor singleclick = new DefaultCellEditor(new JTextField());
		singleclick.setClickCountToStart(1);
		// set the editor as default
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (i != BookingLineFields.BTWCode.ordinal()
					& i != BookingLineFields.BookingAccountKey.ordinal()
					& i != BookingLineFields.OctopusClient.ordinal()) {
				table.setDefaultEditor(table.getColumnClass(i), singleclick);
			}
		}

		// Add the table to a scrolling pane
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

	}

	public ConflictTabelModel getModel() {
		return model;
	}

	private static class MyRenderer extends DefaultTableCellRenderer {

		Color backgroundColor = getBackground();
		Color foregroundColor = getForeground();

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			setOpaque(true);
			Component c = super.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);
			ConflictTabelModel model = (ConflictTabelModel) table.getModel();
			c.setBackground(backgroundColor);
			c.setForeground(foregroundColor);
			// row properies are shown in foreground
			// cell properties in background
			if (model != null) {
				if (isSelected) {
					c.setBackground(Color.GRAY.brighter());

				} else if (SToABooking.isImportRowValid(model.getRows()
						.get(row))) {
					c.setBackground(Color.GREEN.brighter());
				}
				// unvalid
				if (!model.isCellValid(row, column)) {
					// if value is empty
					if (model.getValueAt(row, column).equals("")) {
						c.setBackground(Color.RED);
					} else {
						c.setForeground(Color.RED);
					}
				}
				// modified
				else if (model.isCellModified(row, column)) {
					c.setForeground(Color.BLUE);
				}

			}
			return c;
		}
	}

}
