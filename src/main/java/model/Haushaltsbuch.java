package model;

import java.util.*;
import lombok.Data;

@Data
public class Haushaltsbuch {
	private final Map<Integer, List<Eintrag>> kalenderwochen;

	public List<Eintrag> getKW(int index) {
		return getKalenderwochen().get(index);
	}

	public int getAnzahlKW() {
		return getKalenderwochen().size();
	}

}