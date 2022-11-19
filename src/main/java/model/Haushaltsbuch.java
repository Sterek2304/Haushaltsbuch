package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Haushaltsbuch {
	@SerializedName("KW1")
	private List<Eintrag> kw1;
	
	@SerializedName("KW2")
	private List<Eintrag> kw2;
	
	@SerializedName("KW3")
	private List<Eintrag> kw3;
	
	@SerializedName("KW4")
	private List<Eintrag> kw4;
	
	@SerializedName("KW5")
	private List<Eintrag> kw5;
	
	@SerializedName("KW6")
	private List<Eintrag> kw6;
	
	@SerializedName("KW7")
	private List<Eintrag> kw7;
	
	@SerializedName("KW8")
	private List<Eintrag> kw8;
	
	@SerializedName("KW9")
	private List<Eintrag> kw9;
	
	@SerializedName("KW10")
	private List<Eintrag> kw10;

	public Map<Integer, List<Eintrag>> haushaltsbuch() {
		HashMap<Integer, List<Eintrag>> eintraege = new HashMap<>();
		eintraege.put(1, kw1);
		eintraege.put(2, kw2);
		eintraege.put(3, kw3);
		eintraege.put(4, kw4);
		eintraege.put(5, kw5);
		eintraege.put(6, kw6);
		eintraege.put(7, kw7);
		eintraege.put(8, kw8);
		eintraege.put(9, kw9);
		eintraege.put(10, kw10);

		return eintraege;
	}

	public List<Eintrag> getKW(int index) {
		return haushaltsbuch().get(index);
	}
}