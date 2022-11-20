package com.example.haushaltsbuchfx;

import controller.HomePageController;
import utils.DataLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Haushaltsbuch;

public class HaushaltsbuchApplictaion extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Haushaltsbuch haushaltsbuch = DataLoader.createHaushaltsbuch();

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
}