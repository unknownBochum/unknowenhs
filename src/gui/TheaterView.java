package gui;

import business.Theaterveranstaltung;
import business.TheaterModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

import java.util.List;

public class TheaterView {
    private TheaterControl theaterControl;
    private TheaterModel theaterModel;

    private Pane pane     					 = new  Pane();
    private Label lblTheater    	 		 = new Label("Theater");
    private Label lblVeranstaltungen    	 = new Label("Veranstaltungen");
    private Label lblName 					 = new Label("Theatername:");
    private Label lblStrasseHnr      		 = new Label("Stra�e und Hausnummer:");
    private Label lblPlzOrt   	 	    	 = new Label("Plz und Ort:");
    private ComboBox<String> cmbBxName		 = new ComboBox<String>();
    private TextField txtStrasseHnr	    	 = new TextField();
    private TextField txtPlz	        	 = new TextField();
    private TextField txtOrt	        	 = new TextField();
    private TextArea txtVeranstaltungen		 = new TextArea();
    private Button btnAnzeigeVeranstaltungen = new Button("Anzeige Veranstaltungen");
    private MenuBar mnbrMenuLeiste  		 = new MenuBar();
    private Menu mnDatei             		 = new Menu("Datei");
    private MenuItem mnItmCsvImport 		 = new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		 = new MenuItem("txt-Import");


    public TheaterView(TheaterControl theaterControl, Stage primaryStage, TheaterModel theaterModel) {
        this.theaterControl = theaterControl;
        this.theaterModel = theaterModel;
    	Scene scene = new Scene(this.pane, 600, 280);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Theatern");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }

    private void initKomponenten(){
    	// Labels
       	lblTheater.setLayoutX(20);
    	lblTheater.setLayoutY(40);
    	Font font = new Font("Arial", 24);
    	lblTheater.setFont(font);
    	lblTheater.setStyle("-fx-font-weight: bold;"); 
    	lblVeranstaltungen.setLayoutX(360);
    	lblVeranstaltungen.setLayoutY(40);
      	lblVeranstaltungen.setFont(font);
       	lblVeranstaltungen.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblStrasseHnr.setLayoutX(20);
    	lblStrasseHnr.setLayoutY(130);
    	lblPlzOrt.setLayoutX(20);
    	lblPlzOrt.setLayoutY(170);
       	pane.getChildren().addAll(lblTheater, lblVeranstaltungen, 
       		lblName, lblStrasseHnr, lblPlzOrt);
    
    	// Textfelder
       	cmbBxName.setLayoutX(170);
       	cmbBxName.setLayoutY(90);
       	cmbBxName.setPrefWidth(170);
    	txtStrasseHnr.setLayoutX(170);
    	txtStrasseHnr.setLayoutY(130);
    	txtStrasseHnr.setPrefWidth(170);
    	txtPlz.setLayoutX(170);
    	txtPlz.setLayoutY(170);
    	txtPlz.setPrefWidth(50);
      	txtOrt.setLayoutX(230);
    	txtOrt.setLayoutY(170);
    	txtOrt.setPrefWidth(110);
       	pane.getChildren().addAll( 
       		cmbBxName, txtStrasseHnr, txtPlz, txtOrt);
     	
        // Textbereich	
        txtVeranstaltungen.setEditable(false);
     	txtVeranstaltungen.setLayoutX(360);
    	txtVeranstaltungen.setLayoutY(90);
     	txtVeranstaltungen.setPrefWidth(220);
    	txtVeranstaltungen.setPrefHeight(125);
       	pane.getChildren().add(txtVeranstaltungen); 
       	
        // Button
        btnAnzeigeVeranstaltungen.setLayoutX(360);
        btnAnzeigeVeranstaltungen.setLayoutY(230);
        pane.getChildren().add(btnAnzeigeVeranstaltungen); 
        
 		// Menu
   	    mnbrMenuLeiste.getMenus().add(mnDatei);
  	    mnDatei.getItems().add(mnItmCsvImport);
  	    mnDatei.getItems().add(mnItmTxtImport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	  theaterControl.bearbeiteImport("csv");
            }
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	  theaterControl.bearbeiteImport("txt");
            }
	    });
	    cmbBxName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
           	    zeigeTheateradresseAn();
            }
	    });
	    btnAnzeigeVeranstaltungen.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeVeranstaltungenAn();
	        } 
   	    });  
    }
    public void setzeComboBoxNamen(List<Theaterveranstaltung> veranstaltungen) {
        cmbBxName.getItems().clear();
        for (Theaterveranstaltung tv : veranstaltungen) {
            cmbBxName.getItems().add(tv.getName());
        }
    }

    private void zeigeTheateradresseAn() {
        String name = cmbBxName.getValue();
        if (name == null) {
            zeigeInformationsfensterAn("Wählen Sie einen Theaternamen aus.");
        } else {
            Theaterveranstaltung theaterveranstaltung = theaterControl.findeTheaterveranstaltung(name);
            if (theaterveranstaltung != null) {
                txtStrasseHnr.setText(theaterveranstaltung.getStrasseHnr());
                txtPlz.setText(theaterveranstaltung.getPlz());
                txtOrt.setText(theaterveranstaltung.getOrt());
            } else {
                zeigeInformationsfensterAn("Theaterveranstaltung nicht gefunden.");
            }
        }
    }

    private void zeigeVeranstaltungenAn() {
        String name = cmbBxName.getValue();
        if (name == null) {
            zeigeInformationsfensterAn("Wählen Sie einen Theaternamen aus.");
        } else {
            Theaterveranstaltung theaterveranstaltung = theaterControl.findeTheaterveranstaltung(name);
            if (theaterveranstaltung != null) {
                txtVeranstaltungen.setText(theaterveranstaltung.gibTheaterveranstaltungZurueck('\n'));
            } else {
                zeigeInformationsfensterAn("Keine Veranstaltungen verfügbar.");
            }
        }
    }

    public void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(Alert.AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
    }

    public void zeigeFehlermeldungsfensterAn(String titel, String meldung) {
        new MeldungsfensterAnzeiger(Alert.AlertType.ERROR, titel, meldung).zeigeMeldungsfensterAn();
    }
}
