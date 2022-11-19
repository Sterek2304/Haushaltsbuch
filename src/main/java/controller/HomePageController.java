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
    protected void initialize() {
        ausgewaehltesDatumLabel.setText("KW " + ausgewaehlteKW);

        if(ausgewaehlteKW == 1) {
            disableButton(kwZurueckButton);
        }
    }

    @FXML
    protected void onKWVorButtonClick() {
        ausgewaehlteKW++;
        ausgewaehltesDatumLabel.setText("KW " + ausgewaehlteKW);

        if(ausgewaehlteKW == 52) {
            disableButton(kwVorButton);
        }

        if(isKWOverOne() && kwZurueckButton.isDisabled()) {
            enableButton(kwZurueckButton);
        }

        //TODO: Tabelle mit ausgewählter KW aktualisieren
    }

    @FXML
    protected void onKWZurueckButtonClick() {
        ausgewaehlteKW--;
        ausgewaehltesDatumLabel.setText("KW " + ausgewaehlteKW);

        if(ausgewaehlteKW == 1) {
            disableButton(kwZurueckButton);
        }

        if(isKWUnder52() && kwVorButton.isDisabled()) {
            enableButton(kwVorButton);
        }

        //TODO: Tabelle mit ausgewählter KW aktualisieren
    }

    /**
     * return true - wenn die ausgewählte KW > 1 ist
     * */
    private boolean isKWOverOne() {
        return ausgewaehlteKW > 1;
    }

    /**
     * return true - wenn die ausgewählte KW < 52 ist
     * */
    private boolean isKWUnder52() {
        return ausgewaehlteKW < 52;
    }

    /**
     * macht den übergebenen Button "unklickbar"
     * */
    private void disableButton(Button button) {
        button.setDisable(true);
    }

    /**
     * macht den übergebenen Button "klickbar"
     * */
    private void enableButton(Button button) {
        button.setDisable(false);
    }
}
