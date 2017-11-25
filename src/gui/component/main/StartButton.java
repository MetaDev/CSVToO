package gui.component.main;

import gui.component.custom.OKNotificationWindow;
import gui.component.custom.OKCancelNotificationWindow;
import io.FileHandler;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import model.CacheModel;

import model.ConflictTabelModel;
import model.ConflictTabelRow;
import salestoaccountinglogic.SToABooking;
import salestoaccountinglogic.SToAClient;
import util.AppUtil;

/*
 * This button starts the process of reading the csv containing all new bookings
 * It will show a scroll list containing any and all conflicts
 */
public class StartButton extends JButton implements ActionListener {
	private ConflictTabelModel tableModel;

	public StartButton(ConflictTabelModel model) {
		super("Open");
		this.tableModel = model;
		addActionListener(this);
		setPreferredSize(new Dimension(50, 20));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (tableModel.getRows() != null && !tableModel.getRows().isEmpty()) {
			if (!OKCancelNotificationWindow
					.open("Another sales file has already been imported.\n" +
							"Edited values in cells will be lost.\n" +
							"Client mapping is saved.\n" +
							"Press Cancel if you want avoid losing your work.")) {
				return;
			}
		}
		FileDialog fc = new FileDialog(new Frame(), "Save", FileDialog.LOAD);
		fc.setFile("*.csv");
		fc.setVisible(true);
		fc.setTitle("Open SalesForce .csv file");
		String fn = fc.getFile();
		String path = fc.getDirectory();
		if (fn != null && fn != "") {
			tableModel.setAllRows(FileHandler.parseCSV(path + "/" + fn));
		}
                
                     
        
                        
                

	}

}
