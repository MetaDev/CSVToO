package gui.component.custom;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

import model.ConflictTabelModel;

public class ConflictTableComboBoxCellEditor extends DefaultCellEditor {

	@Override
	public Object getCellEditorValue() {
		return ((JComboBox<String>) this.getComponent()).getSelectedItem();
	}

	public ConflictTableComboBoxCellEditor(String[] values) {
		super(new JComboBox<String>(values));
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		JComboBox<String> comboBox = ((JComboBox<String>) this.getComponent());
		//set default value
		ConflictTabelModel model = (ConflictTabelModel) table.getModel();
		comboBox.setSelectedItem(model.getValueAt(row, column));
		// Set the model data of the table
		if (isSelected) {
			comboBox.setSelectedItem(value);	
			model.setValueAt(value, row, column);
		}
		// finally return the component.
		return super.getTableCellEditorComponent(table, value, isSelected, row,
				column);
	}
}
