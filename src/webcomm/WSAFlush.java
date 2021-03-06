package webcomm;

import gui.component.custom.OKNotificationWindow;
import gui.window.main.MainWindow;
import model.FlushModel;
import salestoaccountinglogic.SToAClient;
import util.AppUtil;

import webcomm.octws.BuySellBookingServiceData;
import webcomm.octws.OctopusWS;
import webcomm.octws.RelationServiceData;

/*
 * This class contains all methods used to communicate with the Octopus WS
 * These methods will be executed after use of the program, flushing
 */
public class WSAFlush extends WSAcces {

	private static WSAcces instance;

	public WSAFlush() {
		super("Please wait while the application uploads new data");
	}

	public static WSAcces getInstance() {
		if (instance == null)
			instance = new WSAFlush();
		return instance;
	}

	// flush
	@Override
	public Object execute(OctopusWS webService) {
		String logText = "";
		boolean error = false;
		// send all correct, processed data to Octopus

		// first linked and modified relations

		for (RelationServiceData relation : SToAClient
				.getToUploadValidRelations()) {
			if (!error) {
				int returnValue = webService.insertUpdateRelation(relation);
				// error
				if (returnValue != 0) {
					OKNotificationWindow
							.openError("Something went wrong when adding client: "
									+ webService
											.getErrorDescription(returnValue)
									+ "Please search upload list of new clients and look for clients with null in the adress or other fields,\n"
									+ " edit those clients through the recently edited clients window.\n"
									+ "client: \n"
									+ AppUtil.printRelation(relation)
									+ "\nA new log file has been created with all data concerning the upload error.\n"
									+ "Your Octopus account will not suffer from inconsistent data.\n"
									+ "Please contact developper for further help.");
					// save all upload data and the client or booking that
					// caused the error in a log file
					logText += "------------------------------------------------------\n";
					logText += webService.getErrorDescription(returnValue)
							+ "\n";
					logText += "Error log, created upon failing of uploading this relation:\n";
					error = true;
				}
				logText += AppUtil.printRelation(relation) + "\n";
			}

		}

		// then the new bookings
		for (BuySellBookingServiceData booking : FlushModel
				.getToUploadBookings()) {
			if (!error) {
				int returnValue = webService.insertBuySellBooking(booking);
				if (returnValue != 0) {
					OKNotificationWindow
							.openError("Something went wrong when adding booking: "
									+ webService
											.getErrorDescription(returnValue)
									+ "\n"
									+ "\n booking: "
									+ AppUtil.printBooking(booking)
									+ "\nA new log file can be created with all data concerning the upload error.\n"
									+ "Your Octopus account will not suffer from inconsistent data.\n"
									+ "Please contact developper for further help, enclose saved log file in attachments.");
					// save all upload data and the client or booking that
					// caused
					// the error in a log file
					logText += "------------------------------------------------------\n";
					logText += webService.getErrorDescription(returnValue);
					logText += "Error log, created upon failing of uploading this booking:\n";
					error = true;
				}
			}
			logText += AppUtil.printBooking(booking) + "\n";
		}
		// save logtext to log file
		if (error) {
			AppUtil.saveToLog(logText);
			return null;
		} else {
			// show window, upload complete, please close application
			OKNotificationWindow
					.openWarning("The upload was successful.\nThe application will close.");
			MainWindow.close();

		}
		return null;
	}
}
