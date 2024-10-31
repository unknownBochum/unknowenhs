package gui;

import business.TheaterModel;
import business.Theaterveranstaltung;
import javafx.stage.Stage;
import java.util.ArrayList;

public class TheaterControl {
    private TheaterModel theaterModel;
    private TheaterView theaterView;

    public TheaterControl(Stage stage) {
        this.theaterModel = new TheaterModel();
        this.theaterView = new TheaterView(this, stage, theaterModel);
    }

    public void aktualisiereComboBoxNamen() {
        theaterView.setzeComboBoxNamen(theaterModel.getTheaterveranstaltungen());
    }

    public void bearbeiteImport(String dateityp) {
        try {
            ArrayList<Theaterveranstaltung> veranstaltungen;
            if ("csv".equals(dateityp)) {
                veranstaltungen = theaterModel.leseTheaterveranstaltungenAusCsvDatei();
            } else if ("txt".equals(dateityp)) {
                veranstaltungen = theaterModel.leseTheaterveranstaltungenAusTxtDatei();
            } else {
                throw new Exception();
            }
            theaterModel.setTheaterveranstaltungen(veranstaltungen);
            aktualisiereComboBoxNamen();
            theaterView.zeigeInformationsfensterAn("Die Theaterveranstaltungen sind gelesen worden.");
        } catch (Exception e) {
            theaterView.zeigeFehlermeldungsfensterAn("Fehler beim Lesen", "Die " + dateityp + "-Datei konnte nicht gelesen werden.");
        }
    }

    public Theaterveranstaltung findeTheaterveranstaltung(String name) {
        return theaterModel.gibTheaterveranstaltung(name);
    }
}
