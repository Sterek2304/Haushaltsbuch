package enums;

import com.google.gson.annotations.SerializedName;

public enum Zahlungsweise {
    @SerializedName("")
    KEINE_ZAHLUNGSWEISE("", ""),

    @SerializedName("Karte")
    KARTE("K", "Karte"),

    @SerializedName("Bar")
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
