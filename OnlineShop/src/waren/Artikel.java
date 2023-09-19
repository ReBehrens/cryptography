/**
 * Package für Warenverwaltung.
 * Dieses Package beinhaltet die vorlage sowie die moglichen Warenklassen.
 * ebenso wird hier auch das Lager abgebildet.
 */
package waren;

import java.util.Objects;

/**
 * Vorlage für die einzelnen Artikelklassen.
 * Die Artikelklasse ist <code> abstract </code> und dient als Oberklasse
 * für alle Artikelklassen wie z.b. Buch.java.
 */
public abstract class Artikel {
	
	/**
	 * Vorlage für die Artikelklassen im OnlineShop
	 * Für das erstellen von Artikelklassen in diesem Shop, werden folgende Attribute
	 * berreitgestellt:
	 * 
	 * @param lagerOrt Hier wird das Lager hinterlegt wo die Artikel liegen.
	 * @param hersteller  Beschreibt den Hersteller des Artikels.
	 * @param titel  Beschreibt den Titel des Artikels.
	 * @param artikelnummer beschreibt die Artikelnummer z.b. die ISBN nummer eines Buches.
	 * @param artikelMenge Anzahl der vorhandenen Artikel.
	 * @param artikelPreis Preisangabe des Artikels. 
	 */
	
	protected Lager lagerOrt;
	private String hersteller;
	private String titel;
	private String artikelnummer;
	protected int artikelMenge = 0;
	private double artikelPreis;
	
	
	
	//------
	/**
	 * Standart Konstruktor
	 */
	public Artikel() {
		
	}
	
	/**
	 * Vorlage zum erstellen einer Artikel-instanz.
	 * Dieser Konstruktor dient als vorlage und wird in den Unterklassen Überladen.
	 * 
	 * @param lagerOrt Hier wird das Lager hinterlegt wo die Artikel liegen.
	 * @param hersteller  Beschreibt den Hersteller des Artikels.
	 * @param titel  Beschreibt den Titel des Artikels.
	 * @param artikelnummer beschreibt die Artikelnummer z.b. die ISBN nummer eines Buches.
	 * @param menge Anzahl der vorhandenen Artikel.
	 * @param preis Wert des angelegten Artikels.
	 */
	public Artikel (Lager lagerOrt, String hersteller, String titel, String artikelnummer, int menge, Double preis) {
		this();
		this.lagerOrt = lagerOrt;
		this.hersteller = hersteller;
		this.titel = titel;
		this.artikelnummer = artikelnummer;
		this.artikelMenge = menge;
		this.artikelPreis = preis;
		
		
	/**
	 * Überschreibung der <code>hashCode()</code> Methode
	 * 
	 * zur besseren überprüfung für das Sortiment HashSet wurde diese Methode
	 * überschrieben
	 * 
	 * @return neuer Hashwert der Objekte
	 */
	}
	@Override
	public int hashCode() {
		return Objects.hash(artikelnummer, hersteller, titel);
	}

	
	/**
	 * Überschreibung der <code> equals()</code> Methode
	 * zur besseren überprüfung der Objekte wurde die <code> equals()</code> Überschrieben
	 * 
	 * @param vergleicht mit dem angegebenen Objekt auf gleichheit.
	 * @return <code>true</code> oder <code>false</code> jenachdem ob das Objekt gleich oder ungleich ist
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikel other = (Artikel) obj;
		return Objects.equals(artikelnummer, other.artikelnummer) && Objects.equals(hersteller, other.hersteller)
				&& Objects.equals(titel, other.titel);
	}

	/**
	 * Abstrakte meth. für Export.
	 * Erzeugt einen String mit allen informationen für den Export in CSV datein
	 * die Methode muss in den unterklassen definiert werden.
	 * @return Export-fähiger String
	 */
	public abstract String getStringDB();
	//-----
	/**
	 * Gibt den Hersteller des Artikels aus.
	 * @return hersteller Herstellernamen
	 */
	public String getHersteller() {
		return hersteller;
	}
	
	/**
	 * ändert den Hersteller des Artikels.
	 * @param hersteller Herstellernamen
	 */
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	
	//----
	/**
	 * Gibt den Titel des Artikels aus.
	 * @return titel Titel
	 */
	public String getTitel() {
		return titel;
	}
	
	/**
	 * ändert den Titel des Artikels.
	 * @param titel Titel
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	//----
	/**
	 * Gibt die Artikelnummer des Artikels aus.
	 * @return artikelnummer Artikelnummer
	 */
	public String getArtikelnummer() {
		return artikelnummer;
	}
	
	/**
	 * ändert die Artikelnummer des Artikels.
	 * @param artikelnummer Artikelnummer
	 */
	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	//----
	/**
	 * Gibt die verfügbare Menge des Artikels aus.
	 * @return artikelMenge verfügbare Menge
	 */
	public int getArtikelMenge() {
		return artikelMenge;
	}
	
	/**
	 * ändert die menge des Artikels.
	 * @param artikelMenge verfügbare Menge
	 */
	public void setArtikelMenge(int artikelMenge) {
		this.artikelMenge = artikelMenge;
	}
	
	/**
	 * Vorlage zur Lagerverwaltung.
	 * Diese Abstrakte Methode wird in den Unterklassen angepasst und dient
	 * der Lagerverwaltung. Diese Methode passt den Bestand der Kategorie im Lager java.datatransfer/
	 * z.b. insgesamt sind XX Bücher im Lager.
	 */
	
	//----
	
	/**
	 * Ausgabe vom Artikelpreis.
	 * @return Preis für den Artikel.
	 */
	public double getArtikelPreis() {
		return artikelPreis;
	}
	
	/**
	 * Ändert den Artikelpreis
	 * @param artikelPreis Neuer Artikelpreis.
	 */
	public void setArtikelPreis(double artikelPreis) {
		this.artikelPreis = artikelPreis;
	}
	
	/**
	 * abstrakte methode.
	 * Gibt den Typ des Artikels aus
	 * @return Konstante der Buchklasse als info
	 */
	public abstract String getTYP();

	
	//--------
	/**
	 * abtrakte methode
	 * methode für die Lager Inventur. wird in den Unterklassen definiert.
	 */
	public abstract void lagerInventur();
	
	

}
