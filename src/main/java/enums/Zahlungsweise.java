package enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Zahlungsweise {
    KEINE_ZAHLUNGSWEISE("", ""),
    KARTE("K", "Karte"),
    BAR("B", "Bar");

    private String kuerzel;
    private String beschreibung;

    Zahlungsweise(String kuerzel, String beschreibung) {
        this.kuerzel = kuerzel;
        this.beschreibung = beschreibung;
    }

    public static Zahlungsweise getZahlungsweiseByName(String name) {
        return Zahlungsweise.valueOf(name.toUpperCase());
    }

    public static Zahlungsweise getZahlungsweiseByKuerzel(String kuerzel) {
        return Zahlungsweise.valueOf(kuerzel);
    }

    @JsonValue
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
