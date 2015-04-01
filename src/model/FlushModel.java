package model;

import java.util.Collection;
import java.util.List;

import webcomm.octws.BuySellBookingServiceData;
import webcomm.octws.RelationServiceData;

public class FlushModel {
	
	// bookings added in flush, must be sorted on doc nr
	// because that's the order they're added in
	private static List<BuySellBookingServiceData> toUploadBookings;

	private static Collection<RelationServiceData> toUploadClienst;


	public static void setNewBookings(
			List<BuySellBookingServiceData> newBookings) {
		toUploadBookings=newBookings;
	}

	
	
	public static Collection<BuySellBookingServiceData> getToUploadBookings() {
		return toUploadBookings;
	}



	public static Collection<RelationServiceData> getToUploadClienst() {
		return toUploadClienst;
	}



	public static void setToUploadClienst(Collection<RelationServiceData> toUploadClienst) {
		FlushModel.toUploadClienst = toUploadClienst;
	}

}
