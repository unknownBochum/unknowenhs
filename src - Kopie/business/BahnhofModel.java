package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gui.Bahnhofview;

public class BahnhofModel {

	
	public Bahnhof getBahnhof() {
		return bahnhof;
	}

	public void setBahnhof(Bahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}

	private Bahnhof bahnhof ;
	
	 public void leseAusDatei(String typ) throws IOException{
	    	
	      			BufferedReader ein = new BufferedReader(new FileReader("bahnhof.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.bahnhof = new Bahnhof(zeile[0],zeile[1], Integer.parseInt(zeile[2]),Integer.parseInt(zeile[3]), zeile[4].split("_"));
	      				ein.close();
	      				
	      	  			
		}
			
		public void schreibeBahnhofInCsvDatei() throws IOException{
			
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("BahnhofAusgabe.csv", true));
				aus.write(bahnhof.gibBahnhofZurueck(';'));
				aus.close();
	   			
		}
}

