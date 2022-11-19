package com.example.haushaltsbuchfx;

import com.fasterxml.jackson.databind.JsonNode;
import controller.HomePageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import json.ExcelConverter;
import json.JSONReader;
import model.Haushaltsbuch;

import java.io.File;
import java.io.IOException;

public class HaushaltsbuchApplictaion extends Application {
    private static  final String pathToHaushaltsbuch = "src/main/resources/excel/Haushaltsbuch_2022.xlsx";
    private static final String pathToHaushaltsbuchJson = "src/main/resources/json/eintrag.json";

    @Override
    public void start(Stage stage) throws IOException {
        Haushaltsbuch haushaltsbuch = loadData(pathToHaushaltsbuch, pathToHaushaltsbuchJson);

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

    public static Haushaltsbuch loadData(String pathToExcel, String pathToJSON) {
        File excelFile = new File(pathToExcel);
        ExcelConverter converter = new ExcelConverter();
        JsonNode data = converter.excelToJson(excelFile);

        File jsonFile = new File(pathToJSON);
        converter.writeJsonToFile(jsonFile, data);

        return JSONReader.readObject();
    }
}