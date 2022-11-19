package model;

import java.util.List;

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

	public void print_haushaltsbuch() {
		print("KW1", kw1);
		print("KW2", kw2);
		print("KW3", kw3);
		print("KW4", kw4);
		print("KW5", kw5);
		print("KW6", kw6);
		print("KW7", kw7);
		print("KW8", kw8);
		print("KW9", kw9);
		print("KW10", kw10);
	}
	
	private void print(String monat, List<Eintrag> eintraege) {
		System.out.println(monat + ":");
		eintraege.forEach(System.out::println);
	}
}