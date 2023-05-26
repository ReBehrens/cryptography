/**
 * Projekt aus Uniscript IOBP-1 und -2.
 * Dieser OnlineShop-code endstand auf basis des Scriptes und Ideen.
 * 
 * @author Rene Behrens.
 */


/**
 * HauptPackage des Online Shops.
 * Der shop besteht aus weiteren 3 Packages "ware", "nutzer" und "abwicklung".
 */
package onlineshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import abwicklung.*;
import nutzer.*;
import waren.*;

/**
 * Startpunkt des Codes.
 * Dies ist der Startpunkt des Programmes
 */
public class Main {

	/**
	 * @Param logger Log4j 2 Logger.
	 * 
	 */
	private static Logger logger = LogManager.getRootLogger();
	
	/**
	 * Startmethode
	 * Startmethode des Shops.
	 * es werden testweise artikel etc. initiiert.
	 * @param args standard
	 */
	public static void main(String[] args) {
		
		
		//------ Kunden -----
		Kunde id1 = new Kunde("Müller", "Heinz", "männlich", "1978-02-12", "12332123", false);
		Kunde.addKundenVerwaltung(id1);
		Kunde id2 = new Kunde("Meyer", "Sabine", "weiblich", "1985-05-10", "11920039",  true);
		Kunde.addKundenVerwaltung(id2);
		logger.info(id1);
		logger.info(id2);
		Kunde.getKundenVerwaltung();
		
		//------- Logistig --------
		System.out.println(Lager.getAnzLager());
		Lager lg1 = new Lager();
		System.out.println(Lager.getAnzLager());
		System.out.println("");
		
	
		//-------- Waren ----------
		Artikel buch1 = new Buch(lg1, "Springer", "Java ist auch nur eine Insel", "12344321", 20, 45.00, "Javaman");
		lg1.sortimentErweitern(buch1);
		System.out.println("bestand Artikel " + buch1.getArtikelMenge());
		System.out.println("Lg Buch " + lg1.getBestandBuch());
		System.out.println("lg insg. " + lg1.getLagerBestand());
		System.out.println("");
		
		Artikel buch2 = new Buch(lg1, "Whyn-Books", "Ein Toter Taucher nimmt kein Gold", "56788765", 25, 15.30, "Konsalik");
		lg1.sortimentErweitern(buch2);
		System.out.println("bestand Artikel " + buch2.getArtikelMenge());
		System.out.println("Lg Buch " + lg1.getBestandBuch());
		System.out.println("lg insg. " + lg1.getLagerBestand());
		System.out.println("");
		System.out.println("");
		
		
		//---
		Artikel film1 = new Film(lg1, "Disney", "Das Schöne und das Biest", "10293847", 50, 20.00, "SIDO");
		lg1.sortimentErweitern(film1);
		System.out.println("bestand Artikel " + film1.getArtikelMenge());
		System.out.println("Lg Film " + lg1.getBestandFilm());
		System.out.println("lg insg. " + lg1.getLagerBestand());
		System.out.println("");
		
		Artikel film2 = new Film(lg1, "Lucas Films", "Star Wars 1", "675849302ß", 100, 35.00, "George Lucas");
		lg1.sortimentErweitern(film2);
		System.out.println("bestand Artikel " + film2.getArtikelMenge());
		System.out.println("Lg Film " + lg1.getBestandFilm());
		System.out.println("lg insg. " + lg1.getLagerBestand());
		System.out.println("");
		System.out.println("");
		
		
		//---
		Artikel musik1 = new Musikartikel(lg1, "Metal Studios", "My little Unicorn eating Pizza Hawaii", "13243546", 666, 6.66, "The Crazy Metal Gang");
		lg1.sortimentErweitern(musik1);
		System.out.println("bestand Artikel " + musik1.getArtikelMenge());
		System.out.println("Lg Musik " + lg1.getBestandMusikArt());
		System.out.println("lg insg. " + lg1.getLagerBestand());
		System.out.println("");
		
		Artikel musik2 = new Musikartikel(lg1, "Apocalyps Studios", "You must Die!", "666000666", 671, 20.00, "Ying-Yang-TANG");
		lg1.sortimentErweitern(musik2);
		System.out.println("bestand Artikel " + musik2.getArtikelMenge());
		System.out.println("Lg Musik " + lg1.getBestandMusikArt());
		System.out.println("lg insg. " + lg1.getLagerBestand());
		System.out.println("");
		System.out.println("");
		
		
		//---
		Artikel sp1 = new Spiele(lg1, "Ubisoft", "Rainbow Six", "1337000", 210, 58.00, "Gaming Studios");
		lg1.sortimentErweitern(sp1);
		System.out.println("bestand Artikel " + sp1.getArtikelMenge());
		System.out.println("Lg Spiel " + lg1.getBestandSpiele());
		System.out.println("lg insg. " + lg1.getLagerBestand());
		System.out.println("");
		
		Artikel sp2 = new Spiele(lg1, "VALVE", "Half Life", "123321123321", 7000, 70.95, "VALVE Studios");
		lg1.sortimentErweitern(sp2);
		System.out.println("bestand Artikel " + sp2.getArtikelMenge());
		System.out.println("Lg Spiel " + lg1.getBestandSpiele());
		System.out.println("lg insg. " + lg1.getLagerBestand());
		System.out.println("");
		
		//-------
		
		id1.inWarenkorbLegen(buch1, 1);
		id1.warenkorbLeeren();
		System.out.println(id1.getWarenkorbInhalt());
		System.out.println("");
		System.out.println("");
		
		id1.inWarenkorbLegen(sp2, 1);
		id2.inWarenkorbLegen(sp1, 2);
		id1.inWarenkorbLegen(musik2, 5);
		id2.inWarenkorbLegen(musik2, 1);
		
		System.out.println(id1.getWarenkorbInhalt());
		System.out.println("");
		System.out.println(id2.getWarenkorbInhalt());
		
		System.out.println("");
		id1.kaufen();
		System.out.println("");
		id2.kaufen();
		
		System.out.println(id1.getWarenkorbInhalt());
		System.out.println("");
		System.out.println(id2.getWarenkorbInhalt());
		
		System.out.println("---------");
		System.out.println("");
		lg1.getSortiment();
		
		System.out.println("");
		Bestellung.getBestellListe();
		
		
		
		System.out.println(Bestellung.getNextBestellung().getBestellnummer());
		System.out.println(Bestellung.bestellungErledigt("Bestellung2"));

		System.out.println(Bestellung.getNextBestellung().getBestellnummer());
		System.out.println(Bestellung.bestellungErledigt("Bestellung1"));
		System.out.println(Bestellung.getNextBestellung().getBestellnummer() + " "
						   + Bestellung.getNextBestellung().getBestellDatum());
		System.out.println(id1.getVorname() + " " + id1.getName() + " " + id1.getDatumErstellung());
		
		
	}

}
