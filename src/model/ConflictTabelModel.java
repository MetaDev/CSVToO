package model;

import gui.component.custom.OKNotificationWindow;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import salestoaccountinglogic.SToABooking;
import salestoaccountinglogic.SToABooking.BookingLineFields;
import salestoaccountinglogic.SToAField;
import salestoaccountinglogic.SToAField.ImportFields;

/*
 * Store here: alle rows with conflicts
 * currently selected booking and field
 * whether all bookings are showed or not
 * 
 */
public class ConflictTabelModel extends DefaultTableModel {

    private int nrOfColumns;
    private List<ConflictTabelRow> rows;
    private int[] selectedRow;

    public List<ConflictTabelRow> getRows() {
        return rows;
    }

    public ConflictTabelModel(String[] columnNames) {
        super(columnNames, 0);
        this.nrOfColumns = columnNames.length;
    }

    public void setRowSelected(int row) {
        int previousSelectedRow = -1;
        // reset
        for (int i = 0; i < selectedRow.length; i++) {
            if (selectedRow[i] == 1) {
                previousSelectedRow = i;
            }
            selectedRow[i] = 0;
        }
        selectedRow[row] = 1;
        fireTableRowsUpdated(row, row);
        if (previousSelectedRow != -1) {
            fireTableRowsUpdated(previousSelectedRow, previousSelectedRow);
        }

    }

    public boolean isRowSelected(int row) {
        return selectedRow[row] == 1;
    }

    public void updateClientMapping() {
        for (ConflictTabelRow row : rows) {
            row.updateClientMapping();
        }
        fireTableDataChanged();
    }

    public boolean validImportBooking(String factuurNr, String amount) {
        try {
            return !factuurNr.equals("") && SToAField.parseDouble(amount) != 0;
        } catch (NumberFormatException | ParseException ex) {
            OKNotificationWindow.openError("Booking: " + factuurNr + " has an unreadable booking amount. Please close app and change amount into correct format.", false);
            return false;
        }
    }

    // clone all bookings in here
    // build conflict table rows based on import
    public void setAllRows(List<String[]> allRows) {
        System.out.println(allRows.get(0).length);
        System.out.println(allRows.get(0)[ImportFields.BoekingBedragInclBTW.ordinal()]);
        System.out.println(ImportFields.values().length);
        // something went wrong with parsing csv
        if (allRows == null || allRows.isEmpty()) {
            OKNotificationWindow
                    .openError("Something went wrong when filling the table with data from the csv file.\n"
                            + "Please check if your csv file corresponds to all requirements.", false);
            return;
        }
        if (allRows.get(0).length != ImportFields.values().length) {
            OKNotificationWindow
                    .openError("Something went wrong when filling the table with data from the csv file.\n"
                            + "Your csv has the wrong number of columns. Namely" + allRows.get(0).length + 
                            "and expected was: " + ImportFields.values().length, false);
            return;
        }

        // construct a Conflict table row object for each line
        List<ConflictTabelRow> newRows = new ArrayList<>();
        Set<String> shippingAndHandlingForBookingNrs = new HashSet<>();
        ConflictTabelRow newRow;
        for (String[] line : allRows) {
            // only add booking lines with booking nr and with a price > 0
            if (validImportBooking(line[ImportFields.FactuurNummer.ordinal()],
                    line[ImportFields.BoekingBedragInclBTW.ordinal()])) {

                String bookingNr = line[ImportFields.FactuurNummer.ordinal()];
                //check if two !=0 VAT amounts
               
                //when the shipping vat code is 6 add shipping to 6 idem 21 and 0
                int shippingVTA = Integer.parseInt(line[ImportFields.ShippingAndHandlingVATCode.ordinal()]);
                double shippingAmount =0;
                double TotalVATShipping=0;
                double VAT6Total =0;
                double VAT21Total =0;
                //TODO check whether the amoount or total is used to check for vat type
                double VAT6Only=0;
                double VAT21Only=0;

                try {
                    VAT6Only=SToAField.parseDouble(line[ImportFields.BTW6Amount.ordinal()]);
                    VAT21Only=SToAField.parseDouble(line[ImportFields.BTW21Amount.ordinal()]);
                    VAT6Total = SToAField.parseDouble(line[ImportFields.BTW6Total.ordinal()]);
                    VAT21Total = SToAField.parseDouble(line[ImportFields.BTW21Total.ordinal()]);
                    TotalVATShipping=SToAField.parseDouble(line[ImportFields.BoekingBedragInclBTW.ordinal()]);
                    shippingAmount = SToAField.parseDouble(line[ImportFields.ShippingAndHandlingAmount.ordinal()]);
                    
                } catch (NumberFormatException | ParseException ex) {
                    Logger.getLogger(ConflictTabelModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("total6 before shiping"+VAT6Total);
                VAT6Total+= shippingVTA==6 ? shippingAmount:0;
                VAT21Total+= shippingVTA==21 ? shippingAmount:0;
                System.out.println(line[ImportFields.FactuurNummer.ordinal()]+ ": "+VAT6Total + "  "+ VAT21Total);
                System.out.println("shippign amount"+shippingAmount);
                System.out.println("vat only 6"+ VAT6Only);
                System.out.println("vat only 21"+ VAT21Only);
                //If the line contains both 6 and 21 BTW amounts, split in two lines
                if (VAT6Only != 0 && VAT21Only != 0) {
                    
                    String[] line6BTW = line.clone();
                    line6BTW[ImportFields.BTW21Amount.ordinal()] = "0,00";
                    line6BTW[ImportFields.BTW21Total.ordinal()] = "0,00";
                    newRow = new ConflictTabelRow(line6BTW, VAT6Total);
                    newRows.add(newRow);
                    
                    String[] line21BTW = line.clone();
                    line21BTW[ImportFields.BTW6Amount.ordinal()] = "0,00";
                    line21BTW[ImportFields.BTW6Total.ordinal()] = "0,00";
                    newRow = new ConflictTabelRow(line21BTW, VAT21Total);
                    newRows.add(newRow);
                } else {
                    if (VAT6Only != 0) {
                        newRow = new ConflictTabelRow(line, VAT6Total);

                    }else if (VAT21Only != 0){
                        newRow = new ConflictTabelRow(line, VAT21Total);
                    }else{
                        //both VAT amounts are equal to 0
                        newRow = new ConflictTabelRow(line,TotalVATShipping );
                    }
                    newRows.add(newRow);
                }

            }
        }

        this.rows = newRows;
        selectedRow = new int[allRows.size()];
        fireTableDataChanged();

    }

    @Override
    public int getColumnCount() {
        return nrOfColumns;
    }

    @Override
    public int getRowCount() {
        if (rows != null) {
            return rows.size();
        }
        return 0;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return rows.get(row).getColumn(column);
    }

    @Override
    public void setValueAt(Object obj, int row, int column) {
        rows.get(row).setColumn((String) obj, column);
        fireTableCellUpdated(row, column);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column != BookingLineFields.OctopusClient.ordinal()) {
            return true;
        }
        return false;
    }

    public boolean isCellModified(int row, int column) {
        return rows.get(row).columnIsModified(column);
    }

    public boolean isCellValid(int row, int column) {
        return SToABooking.fieldIsValid(BookingLineFields.values()[column],
                (String) getValueAt(row, column));
    }

    /*
     * reset the whole model
     */
    public void clearAll() {
        rows = null;
        fireTableDataChanged();
    }

    public void removeRows(Collection<ConflictTabelRow> toRemoveRows) {
        rows.removeAll(toRemoveRows);
        fireTableDataChanged();
    }

}
