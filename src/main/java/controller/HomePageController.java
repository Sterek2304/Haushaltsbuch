package controller;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Data;
import model.Eintrag;
import model.Haushaltsbuch;

import java.time.LocalDate;

@Data
public class HomePageController {
    private static IntegerProperty countKW = new SimpleIntegerProperty(1);
    private static IntegerProperty ausgewaehlteKW = new SimpleIntegerProperty();
    @FXML
    private Button kwZurueckButton;
    @FXML
    private Button kwVorButton;
    @FXML
    private Label ausgewaehltesDatumLabel;
    @FXML
    private TableView<Eintrag> contentTable;
    @FXML
    private TableColumn<Eintrag, LocalDate> datumTableCol;
    @FXML
    private TableColumn<Eintrag, Double> betragTableCol;
    @FXML
    private TableColumn<Eintrag, String> beschreibungTableCol;
    @FXML
    private TableColumn<Eintrag, String> kategorieTableCol;
    @FXML
    private TableColumn<Eintrag, String> zahlungsweiseTableCol;
    private Haushaltsbuch haushaltsbuch;

    @FXML
    protected void initialize() {
        Platform.runLater(() -> {
            ausgewaehlteKW.bind(countKW);
            ausgewaehltesDatumLabel.setText("KW " + ausgewaehlteKW.intValue());

            if(countKW.getValue() == 1) {
                disableButton(kwZurueckButton);
            }

            loadData(countKW.getValue());
        });
    }

    @FXML
    protected void onKWVorButtonClick() {
        countKW.set(countKW.getValue() + 1);
        ausgewaehltesDatumLabel.setText("KW " + ausgewaehlteKW.intValue());

        if(haushaltsbuch.getAnzahlKW() == countKW.getValue()) {
            disableButton(kwVorButton);
        }

        if(isKWOverOne() && kwZurueckButton.isDisabled()) {
            enableButton(kwZurueckButton);
        }

        loadData(countKW.getValue());
    }

    @FXML
    protected void onKWZurueckButtonClick() {
        countKW.set(countKW.getValue() - 1);
        ausgewaehltesDatumLabel.setText("KW " + ausgewaehlteKW.intValue());

        if(countKW.getValue() == 1) {
            disableButton(kwZurueckButton);
        }

        if(isKWUnder52() && kwVorButton.isDisabled()) {
            enableButton(kwVorButton);
        }

        loadData(countKW.getValue());
    }

    /**
     * return true - wenn die ausgewählte KW > 1 ist
     * */
    private boolean isKWOverOne() {
        return countKW.getValue() > 1;
    }

    /**
     * return true - wenn die ausgewählte KW < 52 ist
     * */
    private boolean isKWUnder52() {
        return countKW.getValue() < 52;
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

    public void loadData(int kw) {
        ObservableList<Eintrag> data = FXCollections.observableList(haushaltsbuch.getKW(kw));

        datumTableCol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        betragTableCol.setCellValueFactory(new PropertyValueFactory<>("betrag"));
        beschreibungTableCol.setCellValueFactory(new PropertyValueFactory<>("beschreibung"));
        kategorieTableCol.setCellValueFactory(new PropertyValueFactory<>("kategorie"));
        zahlungsweiseTableCol.setCellValueFactory(new PropertyValueFactory<>("zahlungsweise"));

        contentTable.setItems(data);
    }
}
