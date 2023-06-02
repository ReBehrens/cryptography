package waren;


import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
	  * @param anzLager static int enthält die Anzahl an existierenden Lager.
	  * @param lagerOrte static ArrayList Speichert alle Lager objekte.
	  * @param sep static File trennzeichen
	  * @param homePfad static String sucht den HomePfad des Benutzers.
	  * @param dateiName static enthält den Dateiname der Datenbank für die Lagerhäuser inkl. Ware 
	  * @param dateiPfad static enthält den Versteichnispfad inkl Dateiname.
	  * 
	  * @param verzeichnisPfad static File-objekt das für die Navigation zum speicherverzeichnis führt.
	  * @param datei static File-objekt das für die Navigation zu datei führt.
	  * 
	  * @param bestandBuch Beinhaltet die Gesamtmenge aller Bücher in diesem Lager.
	  * @param bestandFilm Beinhaltet die Gesamtmenge aller Filme in diesem Lager.
	  * @param bestandMusikArt Beinhaltet die Gesamtmenge aller Musikartikel in diesem Lager.
	  * @param bestandSpiele Beinhaltet die Gesamtmenge aller Spiele in diesem Lager.
	  * 
	  * @param bestandArt Beinhaltet die Gesamtmenge aller Artikel in diesem Lager.
	  * @param anzLager enthält die Anzahl an existierenden Lager.
	  */
	private static int anzLager = 0;
	private static ArrayList<Lager> lagerOrte = new ArrayList<>();
	
	private static String sep = File.separator;
	private static String homePfad = System.getProperty("user.home");
	private static String dateiName = "artikelDB.CSV";
	private static String dateiPfad = homePfad + sep + "onlineshop" + sep;
	
	private static File verzeichnisPfad = new File(dateiPfad);
	private static File datei = new File(dateiPfad + sep + dateiName);
	
	private String lagername;
	private int bestandBuch = 0;
	private int bestandFilm = 0;
	private int bestandMusikArt = 0;
	private int bestandSpiele = 0;
	
	private int bestandArt = 0;
	
	private HashSet<Artikel> sortiment;

	
	//---------------------------------------
	
	/**
	 * Hinzufügern des Lagerorts in die liste
	 * Fügt das Lager in eine ArrayList hinzu.
	 * @param name Name des zu speichernden Lagers
	 */
	public static void addLager(Lager name) {
		lagerOrte.add(name);
	}
	
	/**
	 * Prüfen ob das Speicher Verzeichnis Existiert
	 * @return Gibt ein <code> true </code> aus wenn das Verz. existier und schreibbar ist.
	 */
	public static Boolean CheckVerzeichnis() {
		if(datei.exists() && datei.canWrite()) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * erstellen eines Verz. und eine DB datei
	 * anschließend wird über die <code> CheckVerzeichnis() </code> erneut überprüft,
	 * ob nun alles vorhanden ist.
	 * @return gibt ein <code> true </code> zurück wenn die erstellung erfolgreich war.
	 */
	public static Boolean createVerzeichnis() {
		try {
			if(verzeichnisPfad.mkdirs() == true && datei.createNewFile() == true) {
				if(CheckVerzeichnis() == true) return true;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * exportieren der DB (Lager und Waren)
	 */
	public static void exportDatenbank() {
		Boolean check = false;
		try {
			if(CheckVerzeichnis() == false) {
				if(createVerzeichnis() == true) {
					if (CheckVerzeichnis() == true) {
					}
				}
			} else if(CheckVerzeichnis() == true) check = true;
			
			if(check == true) {
				FileWriter writer = new FileWriter(datei);
				for(Lager l : lagerOrte) {
					String s = "\"" + l.getLagername();
					for(Artikel lagerWare : l.sortiment) {
						writer.write(s + "\",\"" + lagerWare.getStringDB());
					}
				}
				writer.close();
				System.out.println("Datei Erstellt");
			} else {
				System.out.println("DB Speicher Fehler");
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	
	//-----------------
	
	/**
	 * Gibt den Namen des Lagers aus
	 * @return String Lagername
	 */
	public String getLagername() {
		return lagername;
	}
	
	
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
	
	
	/**
	 * erstellt eine Lager-instandz.
	 * zusätzlich wird <code> anzLager++ </code> ausgeführt um die Anzahl der existierenden Lager zu erweitern.
	 * 
	 * @param name Lager name
	 */
	public Lager(String name) {
		this.lagername = name;
		anzLager++;
		sortiment = new HashSet<>();
			
		}
}
