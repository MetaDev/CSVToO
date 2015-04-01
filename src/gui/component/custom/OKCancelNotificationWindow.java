package gui.component.custom;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OKCancelNotificationWindow {
	private static JTextArea textArea;
	private static JPanel window;
	private static JFrame parent;

	public static void init(JFrame parent) {
		OKCancelNotificationWindow.parent = parent;
		OKCancelNotificationWindow.window=new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
		textArea = new JTextArea();

		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.setSize(screenSize.getWidth() / 2,
				screenSize.getHeight() / 2);
		window.setPreferredSize(screenSize);
		scrollPane.setMaximumSize(screenSize);
		window.add(scrollPane);
	}

	/*
	 * returns whether the client whiches to continue or not
	 */
	public static boolean open(String message) {
		textArea.setText(message);
		int result = JOptionPane.showConfirmDialog(parent, window, "Warning",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			return true;
		}
		return false;

	}
}
