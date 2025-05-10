package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Database.User.UserHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.gatchasim.gatchasim.Database.User.UserDatabase;
import com.gatchasim.gatchasim.Database.User.LoggedInUser;


public class CCController {

    @FXML
    private ImageView cookieImage;

    @FXML
    private Label currencyLabel;

    @FXML
    private Button clickButton;

    @FXML
    private Button BackToMenuButton;


    private int cookies = 0;

    private final NavigationService navigationService = new NavigationService();
    private final UserDatabase userDatabase = UserDatabase.getInstance();

    private final UserHelper userHelper = new UserHelper(UserDatabase.getInstance());

    @FXML
    private void initialize() {
        clickButton.setOnAction(event -> {
            cookies++;
            updateCurrencyDisplay();
        });

        BackToMenuButton.setOnAction(this::handleReturnToMenu);

        try {
            String username = LoggedInUser.getUsername();
            if (username != null) {
                cookies = userDatabase.getCoinsForUser(username);
                updateCurrencyDisplay();
            }
        } catch (Exception e) {
            System.err.println("Hiba a felhasználó coinjainak betöltésekor: " + e.getMessage());
        }
    }

    private void updateCurrencyDisplay() {
        currencyLabel.setText("Cookies: " + cookies);
    }

    private void handleReturnToMenu(ActionEvent event) {
        String username = LoggedInUser.getUsername();
        if (username != null) {
            userDatabase.updateCoinsForUser(username, cookies);
        }

        navigationService.navigateTo("/com/gatchasim/gatchasim/main_view.fxml", "Főmenü");
        Stage currentStage = (Stage) BackToMenuButton.getScene().getWindow();
        navigationService.closeStage(currentStage);
    }
}