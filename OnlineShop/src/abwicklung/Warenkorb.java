package abwicklung;

import java.util.LinkedList;

import waren.Artikel;

/**
 * Warenkorp für Kaufabwiklung
 * Wird über die <code> Kunde</code> klasse zu jeder Kundeninstanz erzeugt
 * 
 * @author rene
 *
 */

public class Warenkorb {
	
	/**
	 * Zur Kaufabwiglung benötigte Attribute
	 * 
	 * @param anzahlArtikel Gesamtanzahl an Artikel die im Warenkorp gelegt wurden.
	 * @param artikelSumme Der Gesamtpreis der im Warenkopr befindlichen Artikel.
	 */
	private LinkedList<Artikel> ware;
	private int anzahlArtikel;
	private double artikelSumme;
	
	//-------------
	
	/**
	 * Erstellen einer Warenkopr-Instanz
	 * Warenkorp wird Standardgemäß mit 0 Artikeln / Kosten erstellt.
	 */
	public Warenkorb() {
		this.anzahlArtikel = 0;
		this.anzahlArtikel = 0;
		ware = new LinkedList<>();
	}
	//-----------
	/**
	 * Abfrage der anzahl Artikel.
	 * 
	 * @return anzahlArtikel gibt die Anzahl der aktuell im Warenkorp befindlichen Artikel aus.
	 */
	public int getAnzahlArtikel() {
		return anzahlArtikel;
	}
	
	/**
	 * Endern der Artikel anzahl.
	 * @param neueArtikel Param. zur anpassung der im Warenkorp befindlichen Artikel
	 */
	public void setAnzahlArtikel(int neueArtikel) {
		this.anzahlArtikel = this.anzahlArtikel + neueArtikel;
	}
	
	//-----
	/**
	 * Abfrage des Gesamtpreises.
	 * @return artikelSumme Gibt den Gesamtpreis der Artikel aus
	 */
	public double getArtikelSumme() {
		return artikelSumme;
	}

	/**
	 * Änderung des gesamtpreises.
	 * @param artikelPreis Preis des Artikels.
	 * @param artikelMenge Menge der in den Warenkorp gepackten Artikel.
	 */
	public void setArtikelSumme(Double artikelPreis, int artikelMenge) {
		this.artikelSumme = this.artikelSumme + (artikelPreis * artikelMenge);
	}
	//------
	
	/**
	 * Berechnung des Druchschnittpreises.
	 * @return	Gibt den preis im Durchschnitt eines Artikels aus
	 * @throws ArithmeticException wenn durch 0 geteilt wird, wird der fehler gefangen und stattdessen 0.00 ausgegeben.
	 */
	public double preisProArtikel() throws ArithmeticException {
	
		
		try {
			return artikelSumme / anzahlArtikel;
			
		} catch (ArithmeticException ex) {
			return 0.00f;
		}
		
		
	}
	
	/**
	 * Warenkorp Array befüllen.
	 * Es wird der Artikel in den Warenkorp gelegt, dies so oft wie die Anzahl vorgibt.
	 * @param artikel	Dieser Artikel soll in den Warenkorb gelegt werden.
	 * @param anzahl	Die anzahl wie oft dieser Artikel in den Warenkorb gelegt werden soll.
	 */
	public void artikelInWarenkorpSpeichern(Artikel artikel, int anzahl) {
		for( int i = 0; i < anzahl; i++) {
			ware.add(artikel);
		}
	}
	
	/**
	 * Ausgabe der Ware im Warenkorp.
	 * eine erweiterte <code> for </code>-Schleife wird benutzt um alle Artikel im Array
	 * des Warenkorps auszugeben.
	 * 
	 * @return alle Artikel im Warenkorp
	 */
	public String ausgabeWarenkorpInhalt() {
		String result = "";
		
		for(Artikel artikel : ware) {
			result = result + artikel.getTYP() + ": Titel: " + artikel.getTitel() +
												 " Hersteller: " + artikel.getHersteller() +
												 "\n";
		}
		
		return result;
	}
	/**
	 * Gesamten Warenkorb Leeren.
	 */
	public void warenkorpLeeren() {
		this.ware.clear();
		this.anzahlArtikel = 0;
		this.artikelSumme = 0;
	}
	
}