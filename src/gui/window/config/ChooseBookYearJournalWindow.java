package gui.window.config;

import gui.component.custom.LabeledComboBox;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.AppConstants;
import model.CacheModel;

import webcomm.octws.BookyearServiceData;
import webcomm.octws.JournalServiceData;

public class ChooseBookYearJournalWindow extends JPanel {
	private LabeledComboBox bookYearBox;
	private JournalLabelComboBox journalBox;
	// description is bookYear in number
	SortedMap<String, BookyearServiceData> bookYearToDescription;

	public ChooseBookYearJournalWindow() {
		super();

		setLayout(new GridLayout(2, 2));
		bookYearToDescription = new TreeMap<>();
		Map<String, String[]> bookyearDescriptionToJournalName = new HashMap<>();
		for (BookyearServiceData bookYear : CacheModel
				.getAllBookYearsMappedToJournals().keySet()) {
			bookYearToDescription.put(bookYear.getBookyearDescription(),
					bookYear);
			List<JournalServiceData> journals = CacheModel
					.getAllBookYearsMappedToJournals().get(bookYear);
			String[] journalNames = new String[journals.size()];
			for (int i = 0; i < journals.size(); i++) {
				journalNames[i] = journals.get(i).getName();
			}
			bookyearDescriptionToJournalName.put(
					bookYear.getBookyearDescription(), journalNames);
		}
		String[] bookYearDescriptions = bookYearToDescription.keySet().toArray(
				new String[] {});
		String defaultBookYear = bookYearDescriptions[bookYearDescriptions.length - 1];

		bookYearBox = new LabeledComboBox("Book Years", bookYearDescriptions,
				defaultBookYear);
		journalBox = new JournalLabelComboBox("Journals",
				bookyearDescriptionToJournalName, defaultBookYear);
		// add the journal box as listener to the book year combobox, to change
		// dynamically
		bookYearBox.getComboBox().addItemListener(journalBox);

		add(bookYearBox);
		add(journalBox);

	}

	private JournalServiceData getJournalWithNameFromBookyear(
			BookyearServiceData bookYear, String name) {
		for (JournalServiceData journal : CacheModel
				.getAllBookYearsMappedToJournals().get(bookYear)) {
			if (journal.getName().equals(name)) {
				return journal;
			}
		}
		return null;
	}

	public boolean open(JFrame parent) {
		int result = JOptionPane.showConfirmDialog(parent, this,
				"Please choose the active book year and sales journal",
				JOptionPane.PLAIN_MESSAGE);
		// ok is pressed
		if (result == 0) {
			BookyearServiceData bookYear = bookYearToDescription
					.get(bookYearBox.getComboBox().getSelectedItem());
			JournalServiceData journal = getJournalWithNameFromBookyear(
					bookYear, (String) journalBox.getComboBox()
							.getSelectedItem());
			AppConstants.setActiveBookYearAndJournal(bookYear, journal);

			return true;
		}
		return false;
	}

	private class JournalLabelComboBox extends LabeledComboBox implements
			ItemListener {
		private Map<String, ComboBoxModel> models;

		public JournalLabelComboBox(String label, Map<String, String[]> values,
				String defaultValue) {
			super(label, values.get(defaultValue), values.get(defaultValue)[0]);
			models = new HashMap<>();
			// fill model
			for (String bookYearDescription : values.keySet()) {
				models.put(bookYearDescription, new DefaultComboBoxModel<>(
						values.get(bookYearDescription)));
			}
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				// change journals of combobox
				getComboBox().setModel(models.get((String) e.getItem()));
			}
		}

	}
}
