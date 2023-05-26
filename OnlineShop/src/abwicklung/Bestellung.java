package abwicklung;


import java.util.LinkedList;
import interfaces.DateFormat;


/**
 * Klasse für die Bestellabwickling
 * Diese Klasse enthält eine Queue für die Logistik um die Erste Bestellung
 * auch zu erst abzuwickeln.
 * 
 * @author rene
 */
public class Bestellung {
	
	
	public static int index = 1;
	
	private static LinkedList<Bestellung> bestellListe = new LinkedList <Bestellung>();
	private String gekArtikel;
	private String bestellnummer;
	private String besteller;
	private Double gesamtPreis;
	private String bestellDatum;

	
	/**
	 * Konstruktor zur erstellung einer Bestellung
	 * speichert den inhalt des Warenkorpbs eines Kunden in eine Warteschleife.
	 * in diesem zustand wurden die Artikel gekauft und wartet auf den Versand.
	 * addiert beim aufrufen den Counter auf.
	 * @param korb enthält den Warenkorb des Kunden
	 * @param besteller enthält die information des Kunden (Vor und Nachname)
	 */
	public Bestellung(Warenkorb korb, String besteller) {
		
		this.gekArtikel = korb.ausgabeWarenkorpInhalt();
		this.bestellnummer = "Bestellung" + index;
		this.besteller = besteller;
		this.gesamtPreis = korb.getArtikelSumme();
		this.bestellDatum = DateFormat.newDate();
		index++;
		
		
	}
	
	
	
	/**
	 * Ausgabe der gesammten Bestellwarteschlange
	 */
	public static void getBestellListe() {
		for(Bestellung b : bestellListe) System.out.println(b.getBestellnummer() +
											                " Besteller: "+ b.getBesteller() +
											                " Gesamtpreis: " + b.getGesamtPreis());
	}

	/**
	 * Speichern einer neuen Bestellung
	 * eine neue Bestellung wird am ende der warteschlange angereit.
	 * @param bestellung enthält die neue kundenbestellung
	 */
	public static void setBestellListe(Bestellung bestellung) {
		bestellListe.offer(bestellung);
	}
	
	/**
	 * Ausgabe nächste bestellung in Warteschleife.
	 * gibt die erste Bestellung in der Warteschleife aus, die abgearbeitet werden muss.
	 * 
	 * @return nächste bestellung
	 */
	public static Bestellung getNextBestellung() {
		return bestellListe.peek();
	}
	
	/**
	 * löschen der erledigten bestellung
	 * vergleicht die zu löschende Bestellung mit der reihenfolge in der Warteschleife.
	 * wenn diese identisch sind wird sie gelöscht
	 * @param bestellnummer bestellnummer der zu löschenden Bestellung
	 * @return True/False als bestätigung der löschung.
	 */
	public static boolean bestellungErledigt(String bestellnummer) {
		Bestellung offeneBestellung = bestellListe.peek();
		if(offeneBestellung.getBestellnummer().equals(bestellnummer)) {
			bestellListe.poll();
			return true;
		}
		return false;
	}
	
	
	/**
	 * ausgabe der gekauften Artikel der Bestellung
	 * @return liste von Gekauften Artikel als String
	 */
	public String getGekArtikel() {
		return gekArtikel;
	}

	/**
	 * Ausgabe der Bestellnummer
	 * @return bestellnummer enthält die nummer des counters als nummer.
	 */
	public String getBestellnummer() {
		return bestellnummer;
	}

	/**
	 * Gibt den Namen des Bestellers an
	 * @return Vor- und Nachname des Bestellers.
	 */
	public String getBesteller() {
		return besteller;
	}
	
	/**
	 * Ausgabe der Gesamtsumme der Bestellung
	 * @return gesammtpreis
	 */
	public Double getGesamtPreis() {
		return gesamtPreis;
	}

	/**
	 * zeig das Datum der bestellung
	 * @return datum und uhrzeit.
	 */
	public String getBestellDatum() {
		return bestellDatum;
	}

	
	

}
