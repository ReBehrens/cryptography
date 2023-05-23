package nutzer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import abwicklung.*;
import waren.*;


/**
 * klasse Kunde für bestellprozesse etc.
 * Diese klasse dient der Kaufabwicklung etc.
 * 
 * @author rene
 */
public class Kunde {
	
	/**
	  * Attribute der Kundenklasse.
	  * diese Attribute dienen der identifikation des Kunden und der Kaufabwicklung.
	  * 
	  * @param kundenverwaltung HashMap mit allen kunden und ihren kundennummern.
	  * @param name Nachname des Kunden.
	  * @param vorname Vorname des Kunden.
	  * @param Geschlecht für Statistischen zwecke und der Ansprache.
	  * @param geburtsdatum Geburtsdatum des Kunden.
	  * @param vipKunde dient der abfrage dieser Kunde Sonderkonditionen erhält oder nicht.
	  * @param warenkorb RefLink zur eigenen Warenkorb-instanz für die einzelnen Kunden-Instanz.
	  * @param logger Log4j 2 Logger.
	  */
	private static HashMap<String, Kunde> kundenverwaltung = new HashMap<String, Kunde>();
	
	private String name;
	private String vorname;
	private String geschlecht;
	private String geburtsdatum;
	private String kundennummer;
	private Boolean vipKunde = false;
	private Warenkorb warenkorb;
	private Stack<Bestellung> bestellhistorie;
	
	
	//----
	
	/**
	 * Erstellt eine Kunden-instanz mit angepassten Attributen.
	 * Zusätzlich wird eine passende neue Warenkorb-Instanz zu jeder Kunden-Instanz erstellt und verknüpft
	 * 
	 * @param name Nachname des Kunden.
	  * @param vorname Vorname des Kunden.
	  * @param geschlecht für Statistischen zwecke und der Ansprache.
	  * @param geburtsdatum Geburtsdatum des Kunden.
	  * @param vip dient der abfrage dieser Kunde Sonderkonditionen erhält oder nicht.
	  */
	public Kunde (String name, String vorname, String geschlecht, String geburtsdatum, String kundennummer, Boolean vip) {
		this.name = name;
		this.vorname = vorname;
		this.geschlecht = geschlecht;
		this.geburtsdatum = geburtsdatum;
		this.kundennummer = kundennummer;
		this.vipKunde = vip;
		this.warenkorb = new Warenkorb();
		this.bestellhistorie = new Stack<>();
	}
	
	
	//------
	/**
	 * gibt den Nachnamen des Kunden aus.
	 * @return name Nachname
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Anpassen des Nachnamens vom Kunden.
	 * @param name Nachname
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	//---
	/**
	 * gibt den Vornamen des Kunden aus.
	 * @return vorname Vorname
	 */
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * Anpassen des Vornamens vom Kunden.
	 * @param vorname Vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	//---
	/**
	 * gibt das Geschlecht des Kunden aus.
	 * @return geschlecht Geschlecht
	 */
	public String getGeschlecht() {
		return geschlecht; 
	}
	
	/**
	 * Ändert das Geschlecht des Kunden.
	 * @param geschlecht Geschlecht
	 */
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	//---
	/**
	 * gibt das Geburtsdatum des Kunden aus.
	 * @return geburtsdatum Geburtsdatum
	 */
	public String getGeburtsdatumg() {
		return geburtsdatum;
	}
	
	/**
	 * Ändert das Geburtsdatum des Kunden.
	 * @param geburtsdatum Geburtsdatum
	 */
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	//---
	/**
	 * Ausgabe der Kundennummer des Kundens
	 * @return
	 */
	public String getKundennummer() {
		return kundennummer;
	}
	
	/**
	 * Ändern der Kundennummer eines Kundens
	 * @param kundennummer
	 */
	public void setKundennummer(String kundennummer) {
		this.kundennummer = kundennummer;
	}
	
	//---
	/**
	 * abfrage VIP Status
	 * @return vipKunde Status
	 */
	public Boolean getVipKunde() {
		return vipKunde;
	}
	
	/**
	 * Anpassung des VIP Status
	 * @param vipKunde Status
	 */
	public void setVipKunde(Boolean vipKunde) {
		this.vipKunde = vipKunde;
	}
	//-----------
	
	/**
	 * Methode zur Kaufabwicklung.
	 * zur befüllung des Arrays im Warenkorb.
	 * @param artikel	welcher Artikel soll in den Warenkorp gelegt werden.
	 * @param anzahl	Anzahl der Artikel für den Warenkorb.
	 */
	public void inWarenkorbLegen(Artikel artikel, int anzahl) {
		this.warenkorb.artikelInWarenkorpSpeichern(artikel, anzahl);
		this.warenkorb.setAnzahlArtikel(anzahl);
		this.warenkorb.setArtikelSumme(artikel.getArtikelPreis(), anzahl);
		
	}
	/**
	 * Ausgabe aller Artikel im Warenkorb.
	 * 
	 */
	public String getWarenkorbInhalt() {
		String result = "Kunde: " + this.getVorname() + " " + this.getName() + "\n";
		return result = result + this.warenkorb.ausgabeWarenkorpInhalt();
	}
	/**
	 * Lerren des Warenkorbs
	 */
	public void warenkorbLeeren() {
		this.warenkorb.warenkorpLeeren();
	}
	
	//----
	
	/**
	 * hinzufügen eines Kunden in die Datenbank.
	 * HashMap 
	 * @param kunde neuer Kunde.
	 */
	public static void addKundenVerwaltung(Kunde kunde) {
		kundenverwaltung.put(kunde.getKundennummer(), kunde);
		
		
	}
	
	 /**
	  * Ausgabe der gesammten Kunden in der verwaltung.
	  */
	public static void getKundenVerwaltung() {
		
		for(Map.Entry<String, Kunde> k : kundenverwaltung.entrySet()) {
			System.out.println(k.getValue() + " Kn: " + k.getKey());
			
		}
	}
	
	public void kaufen() {
		Bestellung bestellung = new Bestellung(warenkorb, (getVorname() + getName()));
		Bestellung.setBestellListe(bestellung);
		bestellhistorie.add(bestellung);
		warenkorb.warenkorpLeeren();
		
	}
	
	
	
}
