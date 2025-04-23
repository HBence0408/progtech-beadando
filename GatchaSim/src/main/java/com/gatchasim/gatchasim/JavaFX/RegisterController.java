package com.gatchasim.gatchasim.JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Label messageLabel;

    private final NavigationService navigationService = new NavigationService();

    @FXML
    private void handleRegister(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            messageLabel.setText("Passwords do not match.");
            return;
        } //Metódus módosítása ha megvan az adatbázis

        //TODO: Regisztrációs logika megoldása  (szükséges az Adatbázis felépítés hozzá majd megcsinálom ha az is kész van)
        messageLabel.setText("Registration successful!");

        navigationService.navigateTo("/com/gatchasim/gatchasim/login_view.fxml", "Bejelentkezés!");
        Stage currentStage = (Stage) usernameField.getScene().getWindow();
        navigationService.closeStage(currentStage);
    }

    @FXML
    private void goBackToLogin(ActionEvent event) {
        navigationService.navigateTo("/com/gatchasim/gatchasim/login_view.fxml", "Bejelentkezés!");
        Stage currentStage = (Stage) usernameField.getScene().getWindow();
        navigationService.closeStage(currentStage);
    }
}

