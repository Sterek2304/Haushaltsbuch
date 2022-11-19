package controller;

import javafx.application.Platform;
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
    private static int ausgewaehlteKW = 1;

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
            ausgewaehltesDatumLabel.setText("KW " + ausgewaehlteKW);

            if(ausgewaehlteKW == 1) {
                disableButton(kwZurueckButton);
            }

            loadData(ausgewaehlteKW);
        });
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

        loadData(ausgewaehlteKW);
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

        loadData(ausgewaehlteKW);
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
