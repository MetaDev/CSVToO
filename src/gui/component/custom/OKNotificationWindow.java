package gui.component.custom;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class OKNotificationWindow {

    private static JTextArea textArea;
    private static JFrame parent;
    private static JPanel window;

    public static void init(JFrame parent) {
        OKNotificationWindow.parent = parent;
        OKNotificationWindow.textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        window = new JPanel();
        window.add(scrollPane);
    }

    public static void openError(String message, boolean newThread) {
        textArea.setText(message);
        if (newThread) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showConfirmDialog(parent, window, "Error",
                            JOptionPane.PLAIN_MESSAGE);
                }
            });
        } else {
            JOptionPane.showConfirmDialog(parent, window, "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    //if already in another thread no new thread should be spawned

    public static void openWarning(String message, boolean newThread) {
        textArea.setText(message);
        if (newThread) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showConfirmDialog(parent, window, "Warning",
                            JOptionPane.PLAIN_MESSAGE);
                }
            });
        } else {
            JOptionPane.showConfirmDialog(parent, window, "Warning",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

}
