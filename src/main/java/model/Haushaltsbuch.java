package model;

import java.util.*;
import lombok.Data;

@Data
public class Haushaltsbuch {
	private Map<Integer, List<Eintrag>> kalenderwochen;

	public Haushaltsbuch() {
		this.kalenderwochen = new HashMap<>();
	}

	public Haushaltsbuch(Map<Integer, List<Eintrag>> kalenderwochen) {
		this.kalenderwochen = kalenderwochen;
	}

	public List<Eintrag> getKW(int index) {
		return getKalenderwochen().get(index);
	}

	public int getAnzahlKW() {
		return getKalenderwochen().size();
	}

}