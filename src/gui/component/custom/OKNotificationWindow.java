package gui.component.custom;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OKNotificationWindow{
	private static JTextArea textArea;
	private static JFrame parent;
	private static JPanel window;
	public static void init(JFrame parent){
		OKNotificationWindow.parent=parent;
		OKNotificationWindow.textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		window=new JPanel();
		window.add(scrollPane);
	}
	

	
	public static void openError(String message){
		textArea.setText(message);
		JOptionPane.showConfirmDialog(parent, window, "Error",
				JOptionPane.PLAIN_MESSAGE);
	}
	public static void openWarning(String message){
		textArea.setText(message);
		JOptionPane.showConfirmDialog(parent, window, "Warning",
				JOptionPane.PLAIN_MESSAGE);
	}
	
}
