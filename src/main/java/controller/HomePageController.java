package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomePageController {
    private static int ausgewaehlteKW = 1;

    @FXML
    private Button kwZurueckButton;

    @FXML
    private Button kwVorButton;

    @FXML
    private Label ausgewaehltesDatumLabel;

    @FXML
    protected void onKWVorButtonClick() {
        if(ausgewaehlteKW < 52) {
            ausgewaehlteKW++;
        } else {
            kwVorButton.setDisable(true);
        }

        ausgewaehltesDatumLabel.setText("KW " + ausgewaehlteKW);

        //TODO: Tabelle mit ausgewählter KW aktualisieren
    }

    @FXML
    protected void onKWZurueckButtonCilick() {
        if(ausgewaehlteKW > 1) {
            ausgewaehlteKW--;
        } else {
            kwZurueckButton.setDisable(true);
        }

        ausgewaehltesDatumLabel.setText("KW " + ausgewaehlteKW);

        //TODO: Tabelle mit ausgewählter KW aktualisieren
    }


}
