package waren;

/**
 * Unterklasse für Filme
 * Diese Klasse ist eine Unterklasse und erbt von der Klasse Artikel.
 * 
 * @author rene
 *
 */
public class Film extends Artikel {
	
	/**
	 * Zusätzliches Attribut
	 * 
	 * @param regissuer Beschreibt den Regissuer des Filmes
	 */
	private String regisseur;
	private String TYP = "Film";
	
	//-----

	/**
	 * Angepaster Konstruktor der Klasse Film.
	 * erstellen einer Film-Instanz auf basis der Artikelklasse (<code> super(...) </code>) + die Iniziierung der eigenen Attribute.
	 * zusätzlich wird die Methode <code> lagerInventur() </code> zur Lagerverwaltung aufgerufen.
	 * 
	 * @param lagerOrt Hier wird das Lager hinterlegt wo die Artikel liegen.
	 * @param hersteller  Beschreibt den Hersteller des Artikels.
	 * @param titel  Beschreibt den Titel des Artikels.
	 * @param artikelnummer beschreibt die Artikelnummer z.b. die ISBN nummer eines Buches.
	 * @param menge Anzahl der vorhandenen Artikel.
	 * @param preis Preisangabe des Artikels. 
	 * 
	 * @param regisseur Beschreibt den Regissuer des Filmes
	 */
	public Film(Lager lagerOrt, String hersteller, String titel, String artikelnummer, int menge, double preis, String regisseur) {
		super(lagerOrt, hersteller, titel, artikelnummer, menge, preis);
		this.regisseur = regisseur;
		lagerInventur();
		}

	
	//-------------
	/**
	 * Gib den Namen des Regissuer eines Films aus
	 * @return regissuer Regisseurnamen
	 */
	public String getRegisseur() {
		return regisseur;
	}
	
	/**
	 * Ändert den Regissuernamen des Filmes.
	 * @param regisseur Regisseurnamen
	 */
	public void setRegisseur(String regisseur) {
		this.regisseur = regisseur;
	}
	
	/**
	 * Gibt den Typ des Artikels aus
	 * @return Konstante der Buchklasse als info
	 */
	@Override
	public String getTYP() {
		return TYP;
	}

	
	//------------
	/**
	 * Angepasste Lager Inventur Methode.
	 * erzwungende Überschreibung der Abstrakten Methode aus der Artikelklasse.
	 */
	@Override
	public void lagerInventur() {
		this.lagerOrt.setBestandFilm(artikelMenge);
		
	}
}
