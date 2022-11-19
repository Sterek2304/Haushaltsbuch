package json;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import model.Haushaltsbuch;

public class JSONReader {
	private static final String pathName = "src/main/resources/json/eintrag.json";
	private static Gson gson = GsonHelper.getGson();

	/**
	 * ließt den Inhalt der Datei "eintrag.json" aus. Diese darf <b>nur ein
	 * Element</b> enthalten!
	 * 
	 * @return Eintrag
	 */
	public static Haushaltsbuch readObject() {
		Haushaltsbuch eintrag = null;

		try (Reader reader = Files.newBufferedReader(Paths.get(pathName))) {
			eintrag = gson.fromJson(reader, Haushaltsbuch.class);
		} catch (NoSuchFileException nsf) {
			System.out.println(String.format("Die Datei '%s' konnte nicht gefunden werden.", pathName));
		} catch (JsonSyntaxException | JsonIOException json) {
			//System.out.println("Json-Objekt konnte nicht geladen werden.");
			json.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return eintrag;
	}

	/**
	 * ließt den Inhalt der Datei "eintrag.json" aus. Diese enthält eine
	 * <b>Liste</b> von Einträgen!
	 * 
	 * @return ArrayList<Eintrag>
	 */
	public static List<? extends Haushaltsbuch> readAll() {
		List<? extends Haushaltsbuch> eintraege = new ArrayList<>();

		try (Reader reader = Files.newBufferedReader(Paths.get(pathName))) {
			eintraege = gson.fromJson(reader, new TypeToken<ArrayList<? extends Haushaltsbuch>>() {
			}.getType());
		} catch (NoSuchFileException nsf) {
			System.out.println(String.format("Die Datei '%s' konnte nicht gefunden werden.", pathName));
		} catch (JsonSyntaxException | JsonIOException json) {
			System.out.println("Json-Objekt konnte nicht geladen werden.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return eintraege;
	}

}
