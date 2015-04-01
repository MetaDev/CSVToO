package gui.component.custom;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabeledComboBox extends JPanel{
	private JComboBox<String> comboBox;
	private JLabel labelField;
	public LabeledComboBox(String label, String[] values,String defaultValue){
		comboBox=new JComboBox<>(values);
		labelField=new JLabel(label);
		comboBox.setSelectedItem(defaultValue);
		this.add(labelField);
		this.add( comboBox);
		setLayout(new GridLayout(1, 2));
	}
	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	
}
