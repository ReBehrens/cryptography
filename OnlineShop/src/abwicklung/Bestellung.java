package abwicklung;


import java.util.LinkedList;

public class Bestellung {
	
	
	public static int index = 1;
	
	private static LinkedList<Bestellung> bestellListe = new LinkedList <Bestellung>();
	private String gekArtikel;
	private String bestellnummer;
	private String besteller;
	private Double gesamtPreis;

	public Bestellung(Warenkorb korb, String besteller) {
		
		this.gekArtikel = korb.ausgabeWarenkorpInhalt();
		this.bestellnummer = "bestellung" + index;
		this.besteller = besteller;
		this.gesamtPreis = korb.getArtikelSumme();
		index++;
		
		
	}
	
	
	

	public static void getBestellListe() {
		for(Bestellung b : bestellListe) System.out.println(b.getBestellnummer() +
											                " Besteller: "+ b.getBesteller() +
											                " Gesamtpreis: " + b.getGesamtPreis());
	}

	public static void setBestellListe(Bestellung bestellung) {
		bestellListe.add(bestellung);
	}

	public String getGekArtikel() {
		return gekArtikel;
	}

	public String getBestellnummer() {
		return bestellnummer;
	}

	public String getBesteller() {
		return besteller;
	}
	
	public Double getGesamtPreis() {
		return gesamtPreis;
	}


	
	

}
