package com.gatchasim.gatchasim.JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    public Button loginButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;

    private Runnable onLoginSuccess;
    private Runnable onRegister;

    private final NavigationService navigationService = new NavigationService();


    public void setOnLoginSuccess(Runnable onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;
    }

    public void setOnRegister(Runnable onRegister) {
        this.onRegister = onRegister;
    }
    //Az előbbi két metódus az adatbázis összekötés után lesz használva, NE NYÚLJ HOZZÁ ADDIG, köszi
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (authenticateUser(username, password)) {
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            navigationService.navigateTo("/com/gatchasim/gatchasim/main_view.fxml", "Alkalmazás");
            navigationService.closeStage(currentStage);
        } else {
            messageLabel.setText("Nem megfelelő bejelentkezési adatok.");
        }
    }

    @FXML
    private void handleRegister() {
        Stage currentStage = (Stage) loginButton.getScene().getWindow();
        navigationService.navigateTo("/com/gatchasim/gatchasim/register_view.fxml", "Regisztráció");
        navigationService.closeStage(currentStage);
    }

    private boolean authenticateUser(String username, String password) {
        // Ideiglenesen, adatbázissal felülírni
        return username.equals("admin") && password.equals("password");
    }
}