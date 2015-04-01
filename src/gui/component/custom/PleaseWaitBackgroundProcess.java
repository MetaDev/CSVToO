package gui.component.custom;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class PleaseWaitBackgroundProcess {
	/*
	 * Opens a dialog urging the user to wait until operation is done
	 */
	public Object start(JFrame parent, String message, WaitProcess process) {

		JDialog dialog = new JDialog(parent, "Loading",
				ModalityType.APPLICATION_MODAL);
		final WaitProcess finalProcess = process;
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(progressBar, BorderLayout.CENTER);
		panel.add(new JLabel(message), BorderLayout.PAGE_START);
		dialog.add(panel);
		dialog.pack();
		dialog.setLocationRelativeTo(parent);

		RunnableWithResultAndDialog timeConsumingRunnable = new RunnableWithResultAndDialog(process,dialog) ;
		Thread t = new Thread(timeConsumingRunnable);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeConsumingRunnable.getResult();

	}

	class RunnableWithResultAndDialog implements Runnable {
		private WaitProcess process;
		private JDialog dialog;

		public RunnableWithResultAndDialog(WaitProcess process, JDialog dialog) {
			this.process = process;
			this.dialog = dialog;
		}

		private volatile Object result;

		@Override
		public void run() {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					// show dialog

					dialog.setVisible(true);
				}
			});
			// start process
			result = process.execute();
			
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					// show dialog

					dialog.setVisible(false);
				}
			});

			return;
		}

		public Object getResult() {
			return result;
		}
	}
}
