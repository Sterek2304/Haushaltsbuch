package enums;

import com.google.gson.annotations.SerializedName;

public enum Kategorie {
	@SerializedName("?")
	KEINE_KATEGORIE("?", "?"),
	
	@SerializedName("Einkaufen")
	LEBENSMITTEL("L", "Einkaufen"),
	
	@SerializedName("EDV")
	EDV("EDV", "EDV"),
	
	@SerializedName("Uni")
	UNI("Uni", "Uni"),
	
	@SerializedName("W\u00E4sche")
	WAESCHE("W", "W\u00E4sche"),
	
	@SerializedName("Kleidung")
	KLEIDUNG("KL", "Kleidung"),
	
	@SerializedName("Geschenke")
	GESCHENKE("G", "Geschenke"),
	
	@SerializedName("Sonstiges")
	SONSTIGES("So", "Sonstiges"),
	
	@SerializedName("Essen gehen")
	AUSGEHEN("Aus", "Essen gehen"),
	
	@SerializedName("Drogerie")
	DROGERIE("D", "Drogerie"),
	
	@SerializedName("B\u00FCcher")
	BUECHER("B", "B\u00FCcher"),

	@SerializedName("Filme")
	FILME("F", "Filme"),

	@SerializedName("Haushalt")
	HAUSHALT("H", "Haushalt"),

	@SerializedName("Streaming")
	STREAMING("S", "Streaming"),

	@SerializedName("Gehalt")
	GEHALT("G", "Gehalt");
	
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
	
	public String getBeschreibung() {
		return this.beschreibung;
	}
	
	public String toString() {
		return getKuerzel();
	}
}
