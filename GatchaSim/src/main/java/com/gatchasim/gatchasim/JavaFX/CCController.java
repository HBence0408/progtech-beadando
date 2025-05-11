package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Database.Inventory.InventoryDatabase;
import com.gatchasim.gatchasim.Database.User.UserHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.gatchasim.gatchasim.Database.User.UserDatabase;
import com.gatchasim.gatchasim.Database.User.LoggedInUser;
import javafx.scene.image.Image;

import java.net.URL;
import java.sql.SQLException;


public class CCController {

    @FXML
    private ImageView image;

    @FXML
    private Label currencyLabel;

    @FXML
    private Button clickButton;

    @FXML
    private Button BackToMenuButton;


    private int cookies = 0;

    private final NavigationService navigationService = new NavigationService();
    private final UserDatabase userDatabase = UserDatabase.getInstance();
    private final InventoryDatabase inventoryDatabase = InventoryDatabase.getInstance();

    private final UserHelper userHelper = new UserHelper(UserDatabase.getInstance());

    @FXML
    private void initialize() {
        String username = LoggedInUser.getUsername();


        if (username != null) {
            try {
                int userId = userDatabase.getUserIdByUsername(username);
                int rarity = inventoryDatabase.getEquippedItemRarity(userId);
                int multiplier = inventoryDatabase.getEquippedItemMultiplier(userId);

                cookies = userDatabase.getCoinsForUser(username);
                updateCurrencyDisplay();


                String imagePath = getImagePathForRarity(rarity);
                Image loadedImage = new Image(getClass().getResource(imagePath).toExternalForm());
                image.setImage(loadedImage);

                clickButton.setOnAction(event -> {
                    cookies += multiplier;
                    updateCurrencyDisplay();
                });

            } catch (SQLException e) {
                System.err.println("Error while initializing: " + e.getMessage());
            }
        }

        BackToMenuButton.setOnAction(this::handleReturnToMenu);
    }
    private void updateCurrencyDisplay() {
        currencyLabel.setText("Cookies: " + cookies);
    }
    private String getImagePathForRarity(int rarity) {
        switch (rarity) {
            case 3:
                return "/com/gatchasim/gatchasim/three_star.png";
            case 4:
                return "/com/gatchasim/gatchasim/four_star.png";
            case 5:
                return "/com/gatchasim/gatchasim/five_star.png";
            default:
                return "/com/gatchasim/gatchasim/PlaceHolder.jpg";
        }
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