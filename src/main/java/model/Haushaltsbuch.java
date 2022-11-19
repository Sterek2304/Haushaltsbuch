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

	private Map<String, List<Eintrag>> ganzeHaushaltsbuch = new HashMap<>();

	public Haushaltsbuch() {
		ganzeHaushaltsbuch.put("1", kw1);
		ganzeHaushaltsbuch.put("2", kw2);
		ganzeHaushaltsbuch.put("3", kw3);
		ganzeHaushaltsbuch.put("4", kw4);
		ganzeHaushaltsbuch.put("5", kw5);
		ganzeHaushaltsbuch.put("6", kw6);
		ganzeHaushaltsbuch.put("7", kw7);
		ganzeHaushaltsbuch.put("8", kw8);
		ganzeHaushaltsbuch.put("9", kw9);
		ganzeHaushaltsbuch.put("10", kw10);
	}
}