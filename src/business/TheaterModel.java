package business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TheaterModel {
    private List<Theaterveranstaltung> theaterveranstaltungen;

    public ArrayList<Theaterveranstaltung> leseTheaterveranstaltungenAusCsvDatei() throws Exception {
        BufferedReader ein = new BufferedReader(new FileReader("Theaterveranstaltungen.csv"));
        String zeile;
        ArrayList<Theaterveranstaltung> ergebnis = new ArrayList<>();
        while ((zeile = ein.readLine()) != null) {
            String[] zeileAsArray = zeile.split(";");
            ergebnis.add(new Theaterveranstaltung(
                zeileAsArray[0], zeileAsArray[1], zeileAsArray[2], zeileAsArray[3],
                zeileAsArray[4], zeileAsArray[5], Integer.parseInt(zeileAsArray[6])));
        }
        ein.close();
        return ergebnis;
    }

    public ArrayList<Theaterveranstaltung> leseTheaterveranstaltungenAusTxtDatei() throws Exception {
        BufferedReader ein = new BufferedReader(new FileReader("Theaterveranstaltungen.txt"));
        String zeile;
        ArrayList<Theaterveranstaltung> ergebnis = new ArrayList<>();
        while ((zeile = ein.readLine()) != null) {
            ergebnis.add(new Theaterveranstaltung(
                zeile, ein.readLine(), ein.readLine(), ein.readLine(),
                ein.readLine(), ein.readLine(), Integer.parseInt(ein.readLine())));
        }
        ein.close();
        return ergebnis;
    }

    public Theaterveranstaltung gibTheaterveranstaltung(String name) {
        for (Theaterveranstaltung tv : theaterveranstaltungen) {
            if (name.equals(tv.getName())) {
                return tv;
            }
        }
        return null;
    }

    public List<Theaterveranstaltung> getTheaterveranstaltungen() {
        return theaterveranstaltungen;
    }

    public void setTheaterveranstaltungen(List<Theaterveranstaltung> theaterveranstaltungen) {
        this.theaterveranstaltungen = theaterveranstaltungen;
    }
}
