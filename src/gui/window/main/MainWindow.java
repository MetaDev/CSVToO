package gui.window.main;

import gui.component.custom.OKCancelNotificationWindow;
import gui.component.custom.OKNotificationWindow;
import gui.component.main.ConflictScrollList;
import gui.component.main.EndButton;
import gui.component.main.StartButton;
import gui.window.config.LoginWindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import salestoaccountinglogic.SToABooking.BookingLineFields;
import salestoaccountinglogic.SToAConfig;
import util.AppUtil;

public class MainWindow {

    final static JFrame window = new JFrame("Octopus Sales import");

	public static void main(String[] a) {
        try {
            initGUIAndConfig();
            

        } // if app fails save error stack to log file and alert user
        catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String errorStack = sw.toString(); // stack trace as a string

            OKNotificationWindow
                    .openError("An error occured causing the application to crash.\n"
                            + "A log has been saved.\n"
                            + "Try to restart the application, if this fails contact developper.");
            AppUtil.saveToLog(errorStack);
        }
    }

    public static void close() {
        (new Runnable() {
            @Override
            public void run() {
                window.setVisible(false); // you can't see me!
                window.dispose(); // Destroy the JFrame object
                System.exit(0);
            }
        }).run();
    }

    private static void initGUIAndConfig() {
        // initialise mapping stored in config files
        SToAConfig.init();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
				// GUI
                // open in full screen
                window.setExtendedState(JFrame.MAXIMIZED_BOTH);
                window.setVisible(true);

                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        // init gui pop-ups
        OKNotificationWindow.init(window);
        OKCancelNotificationWindow.init(window);
        // login and cache necessary account data
        if (!new LoginWindow().open(window)) {
            close();
            return;
        }
        // if login succesfull
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // fill main panel and add to window
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new BorderLayout());
                // contains buttons open and upload
                JPanel frame1 = new JPanel(new GridLayout(0, 4));
                frame1.setBorder(new EmptyBorder(10, 10, 10, 10));
				// contains list of possible errors in fields from input for
                // output
                ConflictScrollList listPanel = new ConflictScrollList(window,
                        AppUtil.getNamesFromEnum(BookingLineFields.class));
                JPanel frame2 = listPanel;

				// contains gui for output csv
                JLabel labelOpenCSVTF = new JLabel("Open CSV sales file.");

                JLabel labelSaveCSVOct = new JLabel(
                        "Upload valid sales to Octopus.");
                StartButton button1 = new StartButton(listPanel.getModel());
                EndButton button2 = new EndButton(window, listPanel.getModel());
                frame1.add(labelOpenCSVTF);
                frame1.add(button1);
                frame1.add(labelSaveCSVOct);
                frame1.add(button2);

                mainPanel.add(frame1, BorderLayout.PAGE_START);
                mainPanel.add(frame2, BorderLayout.CENTER);
                window.add(mainPanel);
                window.revalidate();
                window.repaint();

            }
        });

    }

}
