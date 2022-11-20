package com.example.haushaltsbuchfx;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.HomePageController;
import excelParser.ExcelConverter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Eintrag;
import model.Haushaltsbuch;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HaushaltsbuchApplictaion extends Application {
    private static final String pathToHaushaltsbuch = "src/main/resources/excel/Haushaltsbuch_2022.xlsx";

    @Override
    public void start(Stage stage) throws IOException {
        Haushaltsbuch haushaltsbuch = loadData(pathToHaushaltsbuch);

        FXMLLoader fxmlLoader = new FXMLLoader(HaushaltsbuchApplictaion.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 795);
        stage.setTitle("Haushaltsbuch");
        stage.setScene(scene);
        stage.show();

        HomePageController controller = fxmlLoader.getController();
        controller.setHaushaltsbuch(haushaltsbuch);
    }

    public static void main(String[] args) {
        launch();
    }

    public static Haushaltsbuch loadData(String pathToExcel) throws IOException {
        File excelFile = new File(pathToExcel);
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