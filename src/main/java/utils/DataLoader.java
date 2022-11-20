package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import model.Eintrag;
import model.Haushaltsbuch;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class DataLoader {
    private static final String pathToHaushaltsbuch = "src/main/resources/excel/Haushaltsbuch_2022.xlsx";
    private Haushaltsbuch haushaltsbuch;

    public static Haushaltsbuch createHaushaltsbuch() throws Exception {
        File excelFile = new File(pathToHaushaltsbuch);
        ExcelConverter converter = new ExcelConverter();
        JsonNode data = converter.excelToJson(excelFile);

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        Map<Integer, List<Eintrag>> kws = new HashMap<>();

        for(int i = 1; i <= 52; i++) {
            String pattern = "KW" + i;
            List<Eintrag> eintraege = mapper.readValue(data.get(pattern).toString(), new TypeReference<>(){});
            kws.put(i, eintraege);
        }

        return new Haushaltsbuch(kws);
    }

}