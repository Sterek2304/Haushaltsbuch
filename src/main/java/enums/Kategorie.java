package enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Kategorie {
	KEINE_KATEGORIE("?", "?"),
	LEBENSMITTEL("L", "Einkaufen"),
	EDV("EDV", "EDV"),
	UNI("Uni", "Uni"),
	WAESCHE("W", "W\u00E4sche"),
	KLEIDUNG("KL", "Kleidung"),
	GESCHENKE("G", "Geschenke"),
	SONSTIGES("So", "Sonstiges"),
	AUSGEHEN("Aus", "Essen gehen"),
	DROGERIE("D", "Drogerie"),
	BUECHER("B", "B\u00FCcher"),
	FILME("F", "Filme"),
	HAUSHALT("H", "Haushalt"),
	STREAMING("S", "Streaming"),
	GEHALT("G", "Gehalt"),
	SNACKS("SN", "Snacks"),
	HANDY("H", "Handy"),
	BESTELLEN("Be", "Bestellen"),
	URLAUB("U", "Urlaub"),
	FREIZEIT("Fr", "Freizeit");
	
	private String kuerzel;
	private String beschreibung;
	
	Kategorie(String kuerzel, String beschreibung) {
		this.kuerzel = kuerzel;
		this.beschreibung = beschreibung;
	}
	
	public static Kategorie getKategorieByBeschreibung(String beschreibung) {
		return Kategorie.valueOf(beschreibung);
	}
	
	public String getKuerzel() {
		return this.kuerzel;
	}

	@JsonValue
	public String getBeschreibung() {
		return this.beschreibung;
	}
	
	public String toString() {
		return getKuerzel();
	}
}
