package gui.component.custom;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import salestoaccountinglogic.SToAClient;
import salestoaccountinglogic.SToAClient.ClientFields;

public class ClientInputField extends JPanel {

	private JTextField textField;
	private JLabel labelField;

	public ClientInputField(String label, String value, ClientFields field) {
		labelField = new JLabel(label);
		// Use field to implement validation
		textField = new JTextField();
		textField.setText(value);
		// verify text field according to enum
		textField.setInputVerifier(new MyInputVerifier(field));
		// Listen for changes in the text
		textField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				validate();
			}

			public void removeUpdate(DocumentEvent e) {
				validate();
			}

			public void insertUpdate(DocumentEvent e) {
				validate();
			}

			public void validate() {
				textField.getInputVerifier().verify(textField);
			}
		});
		setLayout(new GridLayout(1, 2));
		this.add(labelField);
		this.add(textField);

	}

	public void setTextField(JTextField textField) {
		this.remove(this.textField);
		this.add(textField);
		this.textField = textField;
	}

	public JTextField getTextField() {
		return textField;
	}

	private class MyInputVerifier extends InputVerifier {
		private ClientFields field;

		public MyInputVerifier(ClientFields field) {
			super();
			this.field = field;
		}

		@Override
		public boolean verify(JComponent input) {
			String text = ((JTextField) input).getText();
			boolean valid = SToAClient.fieldIsValid(field, text);
			if (!valid) {
				input.setBackground(Color.RED);
			} else {
				input.setBackground(Color.WHITE);
			}
			return valid;
		}
	}
}
