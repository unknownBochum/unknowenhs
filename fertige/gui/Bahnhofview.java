package gui;


import ownUtil.*;

import business.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class Bahnhofview {
	
	private BahnhofModel bahnhofModel; 
	private BahnhofControler bahnhofControler;
    private Bahnhof bahnhof;

	
	 private Pane pane     					= new  Pane();
	    private Label lblEingabe    	 		= new Label("Eingabe");
	    private Label lblAnzeige   	 	    	= new Label("Anzeige");
	    
	    private Label lblName 					= new Label("Name:");
	    private Label lblort   		= new Label(" Ort:");
	    private Label lblanzahlGleise  	 		= new Label("Gleise :");
	    private Label lblletzteRenorvierung   			= new Label("Renorvierung:");
	    private Label lblzugArten  		= new Label("zugArten:");
	    
	    private TextField txtName 	 			= new TextField();
	    private TextField txtort		= new TextField();
	    private TextField txtanzahlGleise		= new TextField();
	    private TextField txtletzteRenovierung			= new TextField();
	    private TextField txtzugArten	= new TextField();
	   
	    private TextArea txtAnzeige  			= new TextArea();
	    private Button btnEingabe 		 		= new Button("Eingabe");
	    private Button btnAnzeige 		 		= new Button("Anzeige");
	    private MenuBar mnbrMenuLeiste  		= new MenuBar();
	    private Menu mnDatei             		= new Menu("Datei");
	    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
	    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
	    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");  
	public Bahnhofview(BahnhofModel bahnhofModel, Stage primaryStage,BahnhofControler bahnhofControler) {
		
		this.bahnhofModel = bahnhofModel;
		this.bahnhofControler = bahnhofControler;
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Bahnhöfe");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
	}
	
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblort.setLayoutX(20);
    	lblort.setLayoutY(130);
    	lblanzahlGleise.setLayoutX(20);
    	lblanzahlGleise.setLayoutY(170);
    	lblletzteRenorvierung.setLayoutX(20);
    	lblletzteRenorvierung.setLayoutY(210);
    	lblzugArten.setLayoutX(20);
    	lblzugArten.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
lblName, lblort, lblanzahlGleise,
       		lblletzteRenorvierung, lblzugArten);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtort.setLayoutX(170);
    	txtort.setLayoutY(130);
    	txtort.setPrefWidth(200);
    	txtanzahlGleise.setLayoutX(170);
    	txtanzahlGleise.setLayoutY(170);
    	txtanzahlGleise.setPrefWidth(200);
      	txtletzteRenovierung.setLayoutX(170);
    	txtletzteRenovierung.setLayoutY(210);
    	txtletzteRenovierung.setPrefWidth(200);
    	txtzugArten.setLayoutX(170);
    	txtzugArten.setLayoutY(250);
    	txtzugArten.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtort, txtanzahlGleise,
     		txtletzteRenovierung, txtzugArten);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    nehmebahnhofAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeBahnhofAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		    	 leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				 schreibeBahnhofInCsvDatei();
			}	
	    });
    }
    
    private void nehmebahnhofAuf(){
    	try{
    		this.bahnhof = new Bahnhof(
    			txtName.getText(), 
   	            txtort.getText(),
   	            Integer.parseInt(txtanzahlGleise.getText()),
    		  Integer.parseInt(txtletzteRenovierung.getText()),
    		    txtzugArten.getText().split(";"));
    		zeigeInformationsfensterAn("Das Bahnhof wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    private void zeigeBahnhofAn(){
    	if(this.bahnhof != null){
    		txtAnzeige.setText(
    			this.bahnhof.gibBahnhofZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Bahnhof aufgenommen!");
    	}
    } 
    
    
    public void leseAusDatei(String typ) {
    	
			bahnhofControler.leseAusDatei(typ);
			this.bahnhof = bahnhofModel.getBahnhof();
	  			
}

    	public void schreibeBahnhofInCsvDatei() {
    		
    		bahnhofModel.setBahnhof(bahnhof);
    		bahnhofControler.schreibeBahnhofInCsvDatei();
	
		
}
    
    public void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    public void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }
	

}
