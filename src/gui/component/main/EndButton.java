package gui.component.main;

import gui.component.custom.OKCancelNotificationWindow;
import gui.component.custom.OKNotificationWindow;
import gui.component.custom.PleaseWaitBackgroundProcess;
import gui.component.custom.WaitProcess;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.ConflictTabelModel;
import model.ConflictTabelRow;
import model.FlushModel;
import salestoaccountinglogic.SToABooking;
import salestoaccountinglogic.SToAClient;
import util.AppUtil;
import webcomm.WSAFlush;
import webcomm.WSCommunicator;

import webcomm.octws.BuySellBookingServiceData;
import webcomm.octws.RelationServiceData;

/*
 * Once this button is pressed the user should've resolved all conflicts of the bookings.
 * if not the user will be alerted that bookings with unresolved conflicts won't be uploaded to Octopus.
 * Once the user agrees all bookings, new or modified clients will be uploaded to Octopus
 */
public class EndButton extends JButton implements ActionListener {

    private ConflictTabelModel tableModel;
    private JFrame parent;

    public EndButton(JFrame parent, ConflictTabelModel model) {
        super("Upload");
        this.parent = parent;
        this.tableModel = model;
        addActionListener(this);
        setPreferredSize(new Dimension(50, 20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // build warning message
        // add all valid bookings to flush model
        final List<ConflictTabelRow> validBookings = new ArrayList<>();

        for (ConflictTabelRow row : tableModel.getRows()) {
            if (SToABooking.isImportRowValid(row)) {
                validBookings.add(row);
            } else {
                OKNotificationWindow
                        .openError("Some fields in the bookinglines are invalid, please correct them all before uploading.");
                return;
            }
        }
        final List<BuySellBookingServiceData> validBookingObjects = SToABooking
                .parseCorrectBookings(validBookings);
        final Collection<RelationServiceData> validRelationObjects = SToAClient
                .getToUploadValidRelations();
        String warningText = "Once OK is pressed all change will be saved permenantly.\n"
                + "This is your edited and new clients, your bookings and you import to octopus client mapping.\n"
                + "New client links:\n\n";
        // add all new mapped clients
        for (Map.Entry<String, String> entry : SToAClient
                .getNewClientsMapping().entrySet()) {

            warningText += entry.getKey() + " ------> "
                    + SToAClient.getClientFromExtID(entry.getValue()).getName()
                    + "\n";

        }
        String bookingHeader = "Valid bookings that will be uploaded: \n\n";
        String relationHeader = "New ,modified or linked clients that will be uploaded: \n\n";

        warningText += AppUtil.printAllBookings(bookingHeader,
                validBookingObjects);
        warningText += AppUtil.printAllClients(relationHeader,
                validRelationObjects);

        // open warning window asking user confirmation
        if (OKCancelNotificationWindow.open(warningText)) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    WaitProcess process = new WaitProcess(validBookingObjects,
                            validRelationObjects) {
                                @Override
                                public Object execute() {

                                    // save valid bookings to flush model
                                    FlushModel
                                    .setNewBookings((List<BuySellBookingServiceData>) super.arg0);
                                    // save new or edited clients
                                    FlushModel
                                    .setToUploadClienst((Collection<RelationServiceData>) super.arg1);
                                    // flush
                                    WSCommunicator.loginAndExecute(WSAFlush
                                            .getInstance());

//only save local AFTER online flush succeed
                                    // save new linked clients to local config mapping
                                    // file
                                    SToAClient.saveAllLinkedClients();

                                    return null;
                                }
                            };
                    // open dialog and execute process
                    new PleaseWaitBackgroundProcess()
                            .start(parent,
                                    "Uploading new/modified clients and new valid bookings",
                                    process);

                }
            }).start();
            //task completed

        }
    }
}
