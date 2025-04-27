package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Database.User.AddUserCommand;
import com.gatchasim.gatchasim.Database.User.UserDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.sql.SQLException;

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
            messageLabel.setText("A jelszavak nem egyeznek!");
            return;
        }

        if (UserDatabase.getInstance().isUsernameTaken(username)) {
            messageLabel.setText("Ez a felhasználónév már létezik!");
            return;
        }

        try {
            AddUserCommand addUserCommand = new AddUserCommand(username, password);
            addUserCommand.execute();

            messageLabel.setText("Sikeres Regisztráció!");

            navigationService.navigateTo("/com/gatchasim/gatchasim/login_view.fxml", "Bejelentkezés!");
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            navigationService.closeStage(currentStage);

        } catch (SQLException e) {
            e.printStackTrace();
            messageLabel.setText("Hiba történt a regisztráció során!");
        }
    }

    @FXML
    private void goBackToLogin(ActionEvent event) {
        navigationService.navigateTo("/com/gatchasim/gatchasim/login_view.fxml", "Bejelentkezés!");
        Stage currentStage = (Stage) usernameField.getScene().getWindow();
        navigationService.closeStage(currentStage);
    }
}

