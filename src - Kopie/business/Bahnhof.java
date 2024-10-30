package business;

public class Bahnhof {
	
	// Name des Buergeramtes
    private String name;
    // Oeffnungszeiten
    private String ort;
    private int anzahlGleise;
    // Strasse und Hausnummer des Buergeramtes
    private int letzteRenevierung;
    // zugarten des Buergeramtes
    private String[] zugarten;

 
    
	
	public Bahnhof(String name, String ort, int anzahlGleise, int letzteRenevierung, String[] zugarten) {
		this.name = name;
		this.ort = ort;
		this.anzahlGleise = anzahlGleise;
		this.letzteRenevierung = letzteRenevierung;
		this.zugarten = zugarten;
	}
	
	
	

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getOrt() {
		return ort;
	}




	public void setOrt(String ort) {
		this.ort = ort;
	}




	public int getAnzahlGleise() {
		return anzahlGleise;
	}




	public void setAnzahlGleise(int anzahlGleise) {
		this.anzahlGleise = anzahlGleise;
	}




	public int getLetzteRenevierung() {
		return letzteRenevierung;
	}




	public void setLetzteRenevierung(int letzteRenevierung) {
		this.letzteRenevierung = letzteRenevierung;
	}




	public String[] getZugarten() {
		return zugarten;
	}




	public void setZugarten(String[] zugarten) {
		this.zugarten = zugarten;
	}




	public String getZugartenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getZugarten().length - 1; i++) {
			ergebnis = ergebnis + this.getZugarten()[i] + trenner; 
		}
		return ergebnis	+ this.getZugarten()[i];
	}
	
	public String gibBahnhofZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getOrt() + trenner
  		    + this.getAnzahlGleise() + trenner
  		    + this.getLetzteRenevierung() + trenner + "\n"
  		    + this.getZugartenAlsString(trenner) + "\n";
  	}
	
	
}

