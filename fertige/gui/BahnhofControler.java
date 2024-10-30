package gui;


import java.io.IOException;
import business.BahnhofModel;
import javafx.stage.Stage;

public class BahnhofControler {
	
	private BahnhofModel bahnhofModel;
	private Bahnhofview bahnhofview;
	public BahnhofControler(Stage stage) {

		this.bahnhofModel = new BahnhofModel();
		this.bahnhofview = new Bahnhofview(bahnhofModel, stage, this);
	}
	
	
	 public void leseAusDatei(String typ){
	    	try {
	      		if("csv".equals(typ)){
	      			bahnhofModel.leseAusDatei(typ);
	      	  			bahnhofview.zeigeInformationsfensterAn(
	      	  	   			"Die Bahnhöfe wurden gelesen!");
	      		}
	       		else{
	       			bahnhofview.zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");
		   		}
			}
			catch(IOException exc){
				bahnhofview.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				bahnhofview.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
			
		public void schreibeBahnhofInCsvDatei() {
			try {
				bahnhofModel.schreibeBahnhofInCsvDatei();
				bahnhofview.zeigeInformationsfensterAn(
		   			"Die Bahnhof wurden gespeichert!");
			}	
			catch(IOException exc){
				bahnhofview.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				bahnhofview.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}
	

}
