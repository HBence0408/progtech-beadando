package com.gatchasim.gatchasim.JavaFX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void setOnLoginSuccess(Runnable onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;
    }

    public void setOnRegister(Runnable onRegister) {
        this.onRegister = onRegister;
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean success = authenticateUser(username, password);

        if (success) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            try {
                // Proper path to your FXML file (update if your folder structure is different)
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/gatchasim/gatchasim/main_view.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 632, 402);
                stage.setScene(scene);
                stage.setTitle("Main Application");
                stage.setResizable(true);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
                messageLabel.setText("Failed to load main view.");
            }
        } else {
            messageLabel.setText("Invalid credentials.");
        }
    }

    @FXML
    private void handleRegister() {
        if (onRegister != null) onRegister.run();
    }

    private boolean authenticateUser(String username, String password) {
        // Ideiglenesen, Adatbázissal felülírni
        return username.equals("admin") && password.equals("password");
    }

}