package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Database.Inventory.GetEquippedItemMultiplierCommand;
import com.gatchasim.gatchasim.Database.Inventory.GetEquippedItemRarityCommand;
import com.gatchasim.gatchasim.Database.Inventory.InventoryDatabase;
import com.gatchasim.gatchasim.Database.User.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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


    @FXML
    private void initialize() {
        String username = LoggedInUser.getUsername();
        GetUserIdByUsernameCommand getUserId = new GetUserIdByUsernameCommand(username);
        GetCoinsForUserCommand getCoins = new GetCoinsForUserCommand();
        if (username != null) {
            try {
                int userId = getUserId.execute();
                GetEquippedItemRarityCommand getRarity = new GetEquippedItemRarityCommand(userId);

                int rarity = getRarity.execute();
                GetEquippedItemMultiplierCommand getMultiplier = new GetEquippedItemMultiplierCommand(userId);
                int multiplier = getMultiplier.execute();

                cookies = getCoins.execute();
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
        UpdateCoinsForUserCommand updateCoins = new UpdateCoinsForUserCommand(cookies);
        if (username != null) {
            updateCoins.execute();
        }

        navigationService.navigateTo("/com/gatchasim/gatchasim/main_view.fxml", "Főmenü");
        Stage currentStage = (Stage) BackToMenuButton.getScene().getWindow();
        navigationService.closeStage(currentStage);
    }
}