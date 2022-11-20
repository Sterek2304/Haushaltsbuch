package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import enums.Kategorie;
import enums.Zahlungsweise;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Eintrag {

	@JsonFormat(pattern = "M/d/yy", shape = JsonFormat.Shape.STRING)
	private LocalDate datum;
	private double betrag;
	private String beschreibung;
	private Kategorie kategorie;
	private Zahlungsweise zahlungsweise;

	public Eintrag() {

	}
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
		return String.format("\t%-13s %-40s %10.2f%-7s %4s - [%s]\n", getGermanDate(), beschreibung, betrag, "\u20AC", kategorie, zahlungsweise);
	}

}
