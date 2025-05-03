package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Database.Inventory.InventoryDatabase;
import com.gatchasim.gatchasim.Database.Inventory.InventoryItem;
import com.gatchasim.gatchasim.Database.User.LoggedInUser;
import com.gatchasim.gatchasim.Database.User.UserDatabase;
import com.gatchasim.gatchasim.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;
import java.util.List;

public class InventoryViewController {

    @FXML
    public Button BackToMenuButton;
    @FXML
    private ListView<InventoryItem> inventoryListView;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        loadInventory();
    }

    private final NavigationService navigationService = new NavigationService();
    private int getUserId(String username) {
        try {
            return UserDatabase.getInstance().getUserIdByUsername(username);
        } catch (SQLException e) {
            messageLabel.setText("Hiba történt a felhasználó ID lekérésekor!");
            Logger.getInstance().logError(e);
            return -1;
        }
    }

    private void loadInventory() {
        inventoryListView.getItems().clear();
        String username = LoggedInUser.getUsername();
        try {
            List<InventoryItem> inventoryItems = InventoryDatabase.getInstance().getUserInventory(username);

            inventoryListView.getItems().addAll(inventoryItems);

            if (inventoryItems.isEmpty()) {
                messageLabel.setText("Az inventory üres.");
            }
        } catch (SQLException e) {
            Logger.getInstance().logError(e);
            messageLabel.setText("Hiba történt az inventory betöltésekor!");
        }
    }

    @FXML
    private void handleEquipItem() {
        InventoryItem selected = inventoryListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            messageLabel.setText("Válassz ki egy itemet!");
            return;
        }

        String username = LoggedInUser.getUsername();
        int userId = getUserId(username);
        if (userId == -1) {
            return;
        }

        try {
            InventoryDatabase.getInstance().equipItem(userId, selected.getInventoryId());
            messageLabel.setText("Item sikeresen equipelve!");
        } catch (SQLException e) {
            Logger.getInstance().logError(e);
            messageLabel.setText("Hiba történt az item equipelésekor!");
        }
    }
    @FXML
    public void handleBackToMenu() {
        navigationService.navigateTo("/com/gatchasim/gatchasim/main_view.fxml", "Főmenü");

        Stage currentStage = (Stage) BackToMenuButton.getScene().getWindow();
        navigationService.closeStage(currentStage);
    }
}