package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LoginController {
    @FXML
    private Label loginTitelLabel;

    @FXML
    protected void onLoginButtonClick() {
        loginTitelLabel.setFont(new Font("Bodoni MT", 20));
        loginTitelLabel.setText("Herzlich Willkommen!");
    }
}