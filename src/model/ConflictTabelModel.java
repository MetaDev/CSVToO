package model;

import gui.component.custom.OKNotificationWindow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import salestoaccountinglogic.SToABooking;
import salestoaccountinglogic.SToABooking.BookingLineFields;
import salestoaccountinglogic.SToAField;
import salestoaccountinglogic.SToAField.ImportFields;

/*
 * Store here: alle rows with conflicts
 * currently selected booking and field
 * whether all bookings are showed or not
 * 
 */
public class ConflictTabelModel extends DefaultTableModel {
	private int nrOfColumns;
	private List<ConflictTabelRow> rows;
	private int[] selectedRow;

	public List<ConflictTabelRow> getRows() {
		return rows;
	}

	public ConflictTabelModel(String[] columnNames) {
		super(columnNames, 0);
		this.nrOfColumns = columnNames.length;
	}

	public void setRowSelected(int row) {
		int previousSelectedRow = -1;
		// reset
		for (int i = 0; i < selectedRow.length; i++) {
			if (selectedRow[i] == 1)
				previousSelectedRow = i;
			selectedRow[i] = 0;
		}
		selectedRow[row] = 1;
		fireTableRowsUpdated(row, row);
		if (previousSelectedRow != -1)
			fireTableRowsUpdated(previousSelectedRow, previousSelectedRow);

	}

	public boolean isRowSelected(int row) {
		return selectedRow[row] == 1;
	}

	public void updateClientMapping() {
		for (ConflictTabelRow row : rows) {
			row.updateClientMapping();
		}
		fireTableDataChanged();
	}

	public boolean validImportBooking(String factuurNr, String amount) {
		return !factuurNr.equals("") && SToAField.parseDouble(amount) != 0;
	}

	// clone all bookings in here
	// build conflict table rows based on import
	public void setAllRows(List<String[]> allRows) {
		// something went wrong with parsing csv
		if (allRows == null || allRows.isEmpty()) {
			OKNotificationWindow
					.openError("Something went wrong when filling the table with data from the csv file.\n"
							+ "Please check if your csv file corresponds to all requirements.");
			return;
		}
		if (allRows.get(0).length != ImportFields.values().length) {
			OKNotificationWindow
					.openError("Something went wrong when filling the table with data from the csv file.\n"
							+ "Your csv has the wrong number of columns.");
			return;
		}

		// construct a Conflict table row object for each line
		List<ConflictTabelRow> newRows = new ArrayList<>();
		ConflictTabelRow newRow;
		for (String[] line : allRows) {
			// only add booking lines with booking nr and with a price > 0
			if (validImportBooking(line[ImportFields.FactuurNummer.ordinal()],
					line[ImportFields.BoekingBedragExclBTW.ordinal()])) {
				newRow = new ConflictTabelRow(line);
				newRows.add(newRow);
			}
		}

		this.rows = newRows;
		selectedRow = new int[allRows.size()];
		fireTableDataChanged();

	}

	@Override
	public int getColumnCount() {
		return nrOfColumns;
	}

	@Override
	public int getRowCount() {
		if (rows != null)
			return rows.size();
		return 0;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return rows.get(row).getColumn(column);
	}

	@Override
	public void setValueAt(Object obj, int row, int column) {
		rows.get(row).setColumn((String) obj, column);
		fireTableCellUpdated(row, column);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column != BookingLineFields.OctopusClient.ordinal()
				&& column != BookingLineFields.KlantID.ordinal()
				&& column != BookingLineFields.FactuurNummer.ordinal()) {
			return true;
		}
		return false;
	}

	public boolean isCellModified(int row, int column) {
		return rows.get(row).columnIsModified(column);
	}

	public boolean isCellValid(int row, int column) {
		return SToABooking.fieldIsValid(getRows().get(row),
				BookingLineFields.values()[column]);
	}

	/*
	 * reset the whole model
	 */
	public void clearAll() {
		rows = null;
		fireTableDataChanged();
	}

	public void removeRows(Collection<ConflictTabelRow> toRemoveRows) {
		rows.removeAll(toRemoveRows);
		fireTableDataChanged();
	}

}
