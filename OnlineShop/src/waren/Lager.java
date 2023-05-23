package waren;

import java.util.HashSet;
import java.util.Iterator;


/**
 * Klasse Lager zur Lagerverwaltung.
 * Diese klasse dient der Lagerverwaltung und beinhaltet die Mengen
 * der Warenkategorien.
 * @author rene
 *
 */
public class Lager {
	
	 /**
	  * Attribute der Lagerklasse.
	  * diese Attribute dienen der übersicht uber die Lager-instanz.
	  * 
	  * @param bestandBuch Beinhaltet die Gesamtmenge aller Bücher in diesem Lager.
	  * @param bestandFilm Beinhaltet die Gesamtmenge aller Filme in diesem Lager.
	  * @param bestandMusikArt Beinhaltet die Gesamtmenge aller Musikartikel in diesem Lager.
	  * @param bestandSpiele Beinhaltet die Gesamtmenge aller Spiele in diesem Lager.
	  * 
	  * @param bestandArt Beinhaltet die Gesamtmenge aller Artikel in diesem Lager.
	  * @param anzLager enthält die Anzahl an existierenden Lager.
	  */
	private int bestandBuch = 0;
	private int bestandFilm = 0;
	private int bestandMusikArt = 0;
	private int bestandSpiele = 0;
	
	private int bestandArt = 0;
	private static int anzLager = 0;
	
	private HashSet<Artikel> sortiment;
	
	//------

	/**
	 * erstellt eine Lager-instandz.
	 * zusätzlich wird <code> anzLager++ </code> ausgeführt um die Anzahl der existierenden Lager zu erweitern.
	 */
	public Lager() {
		anzLager++;
		sortiment = new HashSet<>();
			
		}
	
	
	//-----

	/**
	 * Gibt den Bestand aller Bücher im Lager aus.
	 * @return bestandBuch Bestand aller Bücher
	 */
	public int getBestandBuch() {
		return bestandBuch;
	}
	
	/**
	 * Ändert den Bestand aller Bücher im Lager.
	 * und aktualisiert den allg. Lagerbestand.
	 * @param neuerBestand Bestand aller Bücher
	 */
	public void setBestandBuch(int neuerBestand) {
		this.bestandBuch = this.bestandBuch + neuerBestand;
		setLagerBestand();
	}
	
	//-----
	/**
	 * Gibt den Bestand aller Filme im Lager aus.
	 * @return bestandFilm
	 */
	public int getBestandFilm() {
		return bestandFilm;
	}

	/**
	 * Ändert den Bestand aller Filme im Lager.
	 * und aktualisiert den allg. Lagerbestand.
	 * @param neuerBestand Bestand aller Filme
	 */
	public void setBestandFilm(int neuerBestand) {
		this.bestandFilm = this.bestandFilm + neuerBestand;
		setLagerBestand();
	}

	//-----
	/**
	 * Gibt den Bestand aller Musikartikel im Lager aus.
	 * @return bestandBuch
	 */
	public int getBestandMusikArt() {
		return bestandMusikArt;
	}

	/**
	 * Ändert den Bestand aller Musikartikel im Lager.
	 * und aktualisiert den allg. Lagerbestand.
	 * @param neuerBestand Bestand aller Musikartikel
	 */
	public void setBestandMusikArt(int neuerBestand) {
		this.bestandMusikArt = this.bestandMusikArt + neuerBestand;
		setLagerBestand();
	}

	//-----
	/**
	 * Gibt den Bestand aller Spiele im Lager aus.
	 * @return bestandBuch
	 */
	public int getBestandSpiele() {
		return bestandSpiele;
	}

	/**
	 * Ändert den Bestand aller Spiele im Lager.
	 * und aktualisiert den allg. Lagerbestand.
	 * @param neuerBestand Bestand aller Spiele
	 */
	public void setBestandSpiele(int neuerBestand) {
		this.bestandSpiele = this.bestandSpiele + neuerBestand;
		setLagerBestand();
	}

	//-----
	/**
	 * Gibt den Bestand aller Artikel im Lager aus.
	 * @return bestandBuch Bestand aller Artikel
	 */
	public int getLagerBestand() {
		return bestandArt;
	}
	
	/**
	 * Methode zur berechnung der Gesamtmenge im Lager.
	 * diese Methode ist private und wird nur über andere methoden ausgelöst.
	 */
	private void setLagerBestand() {
		bestandArt = bestandBuch + bestandFilm + bestandMusikArt + bestandSpiele;
	}

	//-----
	/**
	 * Gibt die Anzahl der existierenden Lager aus.
	 * @return anzLager Anzahl Lager
	 */
	public static int getAnzLager() {
		return anzLager;
	}

	/**
	 * Anpassung der Verfügbaren Lager.
	 * @param neuLager Anzahl Lager
	 */
	public static void setAnzLager(int neuLager) {
		anzLager = anzLager + neuLager;
	}

	//-------------------
	
	/**
	 * Sortiment überprüfung.
	 * Überprüft den Bestand des Lagers, ob dieser Artikel bereits vorhanden ist.
	 * @param artikel enthält den Artikel der auf verfügbarkeit überprüft werden soll.
	 * @return wenn Artikel bereits vorhanden <code>false</code>. wenn Artikel noch nicht vorhanden <code> true</code>.
	 */
	public boolean sortimentCheck(Artikel artikel) {
		
		for(Artikel a : this.sortiment) {
			if(a.getTitel().equals(artikel.getTitel())) {
				return false;
			}
		}
		return true;
	}
	
	//---
	/**
	 * Artikel dem Lager Array hinzufügen.
	 * nach überprüfung ob es den Artikel bereits gibt, wird dieser dem Arrays hinzugefügt.
	 * @param artikel Neuer Artikel für das Lager.
	 */
	public void sortimentErweitern(Artikel artikel) {
		
		if(sortimentCheck(artikel)) {
			this.sortiment.add(artikel);
		} else {
			System.out.println("Error: Artikel bereits vorhanden!");
		}
	}
	
	//---
	
	/**
	 * Nicht mehr vorhandene Artikel aus Sortment löschen.
	 * es wird Jeder Artikel auf Bestand geprüft ist die Artikelmenge = 0,
	 * so wird dieser aus dem Sortiment genommen.
	 */
	public void sortimentAufreumen() {
		
		Artikel bestand = null;
		Iterator<Artikel> iterator = this.sortiment.iterator();
		
		while(iterator.hasNext()) {
			bestand = iterator.next();
			if(bestand.getArtikelMenge() == 0)
				iterator.remove();
		}
		
	}
	/**
	 * Ausgabe des aktuellen Sortiments
	 */
	public void getSortiment() {
		
		for(Artikel artikel : sortiment) System.out.println(artikel.getTYP() + ": Titel: " +
															artikel.getTitel() + " Hersteller: " +
															artikel.getHersteller());
		
	}
	
	
	
	
}
