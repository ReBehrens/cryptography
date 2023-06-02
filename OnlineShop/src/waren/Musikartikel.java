package waren;

/**
 * Unterklasse für Musikartikel
 * Diese Klasse ist eine Unterklasse und erbt von der Klasse Artikel.
 * 
 * @author rene
 *
 */
public class Musikartikel extends Artikel {
	
	/**
	 * Zusätzliches Attribut
	 * 
	 * @param interpret Beschreibt den Interpret des Musikartikels.
	 */
	private String interpret;
	private String TYP = "Musikart.";

	//-----
	
	/**
	 * Angepaster Konstruktor der Klasse Musikartikel.
	 * erstellen einer Buch-Instanz auf basis der Artikelklasse (<code> super(...) </code>) + die Iniziierung der eigenen Attribute.
	 * zusätzlich wird die Methode <code> lagerInventur() </code> zur Lagerverwaltung aufgerufen.
	 * 
	 * @param lagerOrt Hier wird das Lager hinterlegt wo die Artikel liegen.
	 * @param hersteller  Beschreibt den Hersteller des Artikels.
	 * @param titel  Beschreibt den Titel des Artikels.
	 * @param artikelnummer beschreibt die Artikelnummer z.b. die ISBN nummer eines Buches.
	 * @param menge Anzahl der vorhandenen Artikel.
	 * @param preis Preisangabe des Artikels. 
	 * 
	 * @param interpret Beschreibt den Interpret des Musikartikels.
	 */
	public Musikartikel(Lager lagerOrt, String hersteller, String titel, String artikelnummer, int menge, double preis, String interpret) {
		super(lagerOrt, hersteller, titel, artikelnummer, menge, preis);
		this.interpret = interpret;
		lagerInventur();
		}
	
	
	//-----
	
	@Override
	public String getStringDB() {
		return this.TYP + "\",\""
			 + getHersteller() + "\",\""
			 + getTitel() + ","
			 + getArtikelnummer() + "\",\""
			 + getArtikelMenge() + "\",\""
			 + getArtikelPreis() + "\",\""
			 + this.interpret + "\","
			 + "\n";		 
	}
	
	
	/**
	 * Gib den Namen des Interprets des Musikartikels aus
	 * @return interpret Interpretennamen
	 */
	public String getInterpret() {
		return interpret;
	}
	
	/**
	 * Ändert den Interpretennamen vom Musikartikel.
	 * @param interpret Interpretennamen
	 */
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}
	
	/**
	 * Gibt den Typ des Artikels aus
	 * @return Konstante der Buchklasse als info
	 */
	@Override
	public String getTYP() {
		return TYP;
	}

	//-------
	
	/**
	 * Angepasste Lager Inventur Methode.
	 * erzwungende Überschreibung der Abstrakten Methode aus der Artikelklasse.
	 */
	@Override
	public void lagerInventur() {
		this.lagerOrt.setBestandMusikArt(artikelMenge);
		
	}
}
