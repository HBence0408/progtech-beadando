package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Database.CommandInvoker;
import com.gatchasim.gatchasim.Database.User.LoggedInUser;
import com.gatchasim.gatchasim.Database.User.LoginUserCommand;
import com.gatchasim.gatchasim.Logger;
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

    private final NavigationService navigationService = new NavigationService();


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
        try {
            CommandInvoker invoker = new CommandInvoker();
            LoginUserCommand loginCommand = new LoginUserCommand(username, password);
            boolean success = invoker.run(loginCommand);

            if (success) {
                LoggedInUser.setUser(username);
                return true;
            }
        } catch (Exception e) {
            String exceptionType = e.getClass().getName();
            System.out.println("Valami Nem kóser: " + exceptionType);
            Logger.getInstance().logError(e);
            System.exit(0);
        }
        return false;
    }
}