package model;

import enums.Kategorie;
import enums.Zahlungsweise;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Eintrag {
	private static final String euroZeichen = "\u20AC";
	//TODO: negative und positive Wert im Haushaltsbuch erlauben
	//		und die Anzeige entsprechend anpassen
	private static final String minusZeichen = "-";
	private static final String plusZeichen = "+";
	private LocalDate datum;
	private double betrag;
	private String beschreibung;
	private Kategorie kategorie;
	private Zahlungsweise zahlungsweise;
	
	public Eintrag(String datum, double betrag, String beschreibung, String kategorie, String zahlungsweise) {
		this.datum = LocalDate.parse(datum);
		this.betrag = betrag;
		this.beschreibung = beschreibung;
		this.kategorie = Kategorie.getKategorieByBeschreibung(kategorie);
		this.zahlungsweise = Zahlungsweise.getZahlungsweiseByKuerzel(zahlungsweise);
	}
	
	public String getGermanDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return formatter.format(datum);
	}

	@Override
	public String toString() {
		return String.format("\t%-13s %-40s - %6.2f%-7s [%s] - (%s)", getGermanDate(), beschreibung, betrag, euroZeichen, kategorie, zahlungsweise);
//		return String.format("\t%-20s - %5.2f%s [%s], ausgegeben am: %s (%s)", beschreibung, betrag, euroZeichen, kategorie, datum, zahlungsweise);
	}

}
