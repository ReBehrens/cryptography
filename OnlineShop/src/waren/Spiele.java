package waren;

/**
 * Unterklasse für Spiele
 * Diese Klasse ist eine Unterklasse und erbt von der Klasse Artikel.
 * 
 * @author rene
 *
 */
public class Spiele extends Artikel {
	
	/**
	 * Zusätzliches Attribut
	 * 
	 * @param autor Beschreibt den Autor des Spiels.
	 */
	private String autor;
	private String TYP = "Spiele";
	

	//-----
	/**
	 * Angepaster Konstruktor der Klasse Spiele.
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
	 * @param autor Beschreibt den Autor des Speils
	 */
	public Spiele(Lager lagerOrt, String hersteller, String titel, String artikelnummer, int menge, double preis, String autor) {
		super(lagerOrt, hersteller, titel, artikelnummer, menge, preis);
		this.autor = autor;
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
			 + this.autor + "\","
			 + "\n";		 
	}
	
	
	/**
	 * Gib den Namen des Autors eines Buches aus
	 * @return autor Autornamen
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Ändert den Autornamen des Buches.
	 * @param autor Autornamen
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/**
	 * Gibt den Typ des Artikels aus
	 * @return Konstante der Spieleklasse als info
	 */
	@Override
	public String getTYP() {
		return TYP;
	}

	
	//-----------
	
	/**
	 * Angepasste Lager Inventur Methode.
	 * erzwungende Überschreibung der Abstrakten Methode aus der Artikelklasse.
	 */
	@Override
	public void lagerInventur() {
		this.lagerOrt.setBestandSpiele(artikelMenge);
		
	}
}
