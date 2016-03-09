package gui.window.client;

import gui.component.custom.ClientInputField;
import gui.component.custom.OKNotificationWindow;
import gui.component.custom.LabeledComboBox;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CacheModel;
import model.ConflictTabelModel;
import model.ConflictTabelRow;
import salestoaccountinglogic.SToABooking.BookingLineFields;
import salestoaccountinglogic.SToAClient;
import salestoaccountinglogic.SToAClient.ClientFields;
import salestoaccountinglogic.SToAField;
import salestoaccountinglogic.SToAField.Language;
import salestoaccountinglogic.SToAField.VATLiability;
import util.AppUtil;
import webcomm.WSDataObjectCreator;

import webcomm.octws.RelationServiceData;

/*
 * A GUI window containing all Octopus client fields, labels and a save button.
 * a reference is kept to the client, so that when the window is closed the changes can be saved in it
 */
public class EditClientWindow extends JPanel {

    private Map<ClientFields, JTextField> inputClientFields = new HashMap<>();
    private Map<ClientFields, JComboBox<String>> comboBoxClientFields = new HashMap<>();

    public EditClientWindow() {
        super();
        setLayout(new GridLayout(0, 2));
    }

    private ClientInputField buildInputField(String label, String value,
            ClientFields field) {
        ClientInputField clientInputField = new ClientInputField(label, value,
                field);
        inputClientFields.put(field, clientInputField.getTextField());
        clientInputField.getTextField().getInputVerifier()
                .verify(clientInputField.getTextField());
        return clientInputField;
    }

    private LabeledComboBox buildInputComboBox(String label, String[] values,
            String defaultValue, ClientFields field) {
        LabeledComboBox clientComboBox = new LabeledComboBox(label, values,
                defaultValue);
        comboBoxClientFields.put(field, clientComboBox.getComboBox());
        return clientComboBox;
    }

    private void loadFromClient(RelationServiceData client) {
		// fill with client fields from client parameter
        // fill frame with a text input and label for every client field

        // Name
        add(buildInputField("Naam", client.getName(), ClientFields.Naam));
        // Adress
        add(buildInputField("Straat en Nummer", client.getStreetAndNr(),
                ClientFields.StraatEnNummer));
        // City
        add(buildInputField("Gemeente", client.getCity(), ClientFields.Gemeente));
        // Postal Code
        add(buildInputField("Postcode", client.getPostalCode(),
                ClientFields.Postcode));
        // Country Code
        add(buildInputField("Land Code", client.getCountry(),
                ClientFields.LandCode));
        // BTWNR
        add(buildInputField("BTW Nummer",
                SToAField.removeDots(client.getVatNr()), ClientFields.BTWNummer));
        // nr of experiationDays
        add(buildInputField("Aantal Vervaldagen", client.getExpirationDays()
                + "", ClientFields.NrOfExperitiationDays));
        add(new JLabel());

		// Booking account
        add(buildInputComboBox("Verkoop Rekening Nummer", CacheModel
                .getSalesBookingAccounts().keySet().toArray(new String[]{}),
                String.valueOf(client.getDefaultBookingAccountClient()),
                ClientFields.BookingAccount));

        // language
        String suggestionLanguage = SToAField.getlanguagedescription(client
                .getFactLanguage());
        if (suggestionLanguage != null) {
            add(buildInputComboBox("Taal",
                    AppUtil.getNamesFromEnum(Language.class),
                    suggestionLanguage, ClientFields.Language));
        } else {
            add(buildInputComboBox("Taal",
                    AppUtil.getNamesFromEnum(Language.class),
                    SToAField.Language.values()[0].name(),
                    ClientFields.Language));
        }

        // BTW plichtigheid
        add(buildInputComboBox("BTW Plichtigheid",
                AppUtil.getNamesFromEnum(VATLiability.class),
                SToAField.getVATLiabilityName(client.getVatType() + ""),
                ClientFields.BTWPlichtigheid));
		// fixed values

        // Experiation type
        add(new JLabel("Factuur Verval Type: Na facturatie"));

        // External ID
        if (client.getExternalRelationNr() == 0) {
            add(new JLabel(
                    "<html>External Octopus ID: <font color='red'>0</font></html>"));
        } else {
            add(new JLabel("External Octopus ID: "
                    + client.getExternalRelationNr()));
        }

        // add empty label to align components
        add(new JLabel());

		// optional
        // IBAN
        add(buildInputField("IBAN Rekening Nummer", client.getIbanAccountNr(),
                ClientFields.IBANNummer));
        // BIC
        add(buildInputField("BIC Code Nummer", client.getBicCode(),
                ClientFields.BICCODE));
    }

    /*
     * Use date from input fields and comboboxes to complete the client
     */
    private void saveToClient(RelationServiceData client) {
        // name
        client.setName(inputClientFields.get(ClientFields.Naam).getText());
        // Adress
        client.setStreetAndNr(inputClientFields
                .get(ClientFields.StraatEnNummer).getText());
        // City
        client.setCity(inputClientFields.get(ClientFields.Gemeente).getText());
        // Postal Code
        client.setPostalCode(inputClientFields.get(ClientFields.Postcode)
                .getText());
        // Country Code
        client.setCountry(inputClientFields.get(ClientFields.LandCode)
                .getText());
        // BTWNr
        client.setVatNr(inputClientFields.get(ClientFields.BTWNummer).getText());
        // IBAN
        client.setIbanAccountNr(inputClientFields.get(ClientFields.IBANNummer)
                .getText());
        // BIC
        client.setBicCode(inputClientFields.get(ClientFields.BICCODE).getText());

		// nr of experiationDays
        // only parse number if not empty
        if (!inputClientFields.get(ClientFields.NrOfExperitiationDays)
                .getText().equals("")) {
            client.setExpirationDays(Integer.parseInt(inputClientFields.get(
                    ClientFields.NrOfExperitiationDays).getText()));
        }
        // BTW plichtigheid
        client.setVatType(Integer.parseInt(SToAField
                .getVATLiabilityCodeByname((String) comboBoxClientFields.get(
                                ClientFields.BTWPlichtigheid).getSelectedItem())));

		// vat experiation type
        // fixed default value
        // Booking account
        client.setDefaultBookingAccountClient(Integer
                .parseInt((String) comboBoxClientFields.get(
                                ClientFields.BookingAccount).getSelectedItem()));
        // language
        client.setFactLanguage(comboBoxClientFields.get(ClientFields.Language)
                .getSelectedIndex());
        // External ID can't change
        client.setExternalRelationNr(SToAClient.getValidExternalID());

    }

    /*
     * opens a dialog and saves edited client on press OK
     */
    private void openDialog(JFrame parent, RelationServiceData client) {
        int result = JOptionPane.showConfirmDialog(null, this,
                "Please fill all client fields.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // save changed data from user to client
            saveToClient(client);
            // check if client with new saved data is valid
            if (!SToAClient.clientIsValid(client)) {
                OKNotificationWindow
                        .openError("One or more fields for client are invalid.\n"
                                + "Please check if validated fields like country code and VAT number don't contain any leading or trailing spaces.", false);
                return;
            }
            // add modified client 
            SToAClient.addNewOrEditedClient(client);
        }
    }

    private void openDialog(JFrame parent, int row, int column,
            RelationServiceData client, ConflictTabelModel model) {
        int result = JOptionPane.showConfirmDialog(null, this,
                "Please fill all client fields.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // save changed data from user to client
            saveToClient(client);
            // check if client with new saved data is valid
            if (!SToAClient.clientIsValid(client)) {
                OKNotificationWindow
                        .openError("One or more fields for client are invalid.\n"
                                + "Please check if validated fields like country code and VAT number don't contain any leading or trailing spaces.", false);
                return;
            }

            // add new ID mapping
            SToAClient.addNewClientMapping(model.getRows().get(row)
                    .getBookingLineField(BookingLineFields.KlantID), client);
            //save to model
            SToAClient.addNewOrEditedClient(client);
            // update mapping in table
            model.updateClientMapping();

        }
    }

    /*
     * open a window with the fields filled by info from tabel row "new client"
     * option
     */
    public void open(JFrame parent, int row, int column,
            ConflictTabelModel model) {
        ConflictTabelRow rowData = model.getRows().get(row);

		// build client from row data
        RelationServiceData client = WSDataObjectCreator.getRelation("0",
                rowData.getClientField(ClientFields.Naam),
                rowData.getClientField(ClientFields.StraatEnNummer),
                rowData.getClientField(ClientFields.Postcode),
                rowData.getClientField(ClientFields.Gemeente),
                rowData.getClientField(ClientFields.LandCode),
                rowData.getClientField(ClientFields.BTWNummer),
                rowData.getClientField(ClientFields.BookingAccount),
                rowData.getClientField(ClientFields.NrOfExperitiationDays),
                rowData.getClientField(ClientFields.Language),
                rowData.getClientField(ClientFields.BTWPlichtigheid), "", "");

        loadFromClient(client);
        // open input box for new client
        openDialog(parent, row, column, client, model);
    }

    /*
     * open window to edit client, "existing" and "linked client" option
     */
    public void open(JFrame parent, RelationServiceData client) {
        loadFromClient(client);
        // open input box for new client
        openDialog(parent, client);

    }
}
