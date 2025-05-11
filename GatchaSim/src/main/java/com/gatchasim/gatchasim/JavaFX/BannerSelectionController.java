package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Database.Banner.BannerDatabase;
import com.gatchasim.gatchasim.Database.Inventory.InventoryDatabase;
import com.gatchasim.gatchasim.Database.User.UserDatabase;
import com.gatchasim.gatchasim.GatchaSystem.Banner;
import com.gatchasim.gatchasim.GatchaSystem.GatchaItem;
import com.gatchasim.gatchasim.GatchaSystem.GatchaSystem;
import com.gatchasim.gatchasim.Database.User.LoggedInUser;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BannerSelectionController {

    @FXML
    private ComboBox<Integer> bannerComboBox;

    @FXML
    private Label coinLabel;

    @FXML
    private Button BackToMenuButton;
    @FXML
    private ListView<String> resultListView;

    private int cookies = 0;

    private Banner currentBanner;
    private final NavigationService navigationService = new NavigationService();
    private final UserDatabase userDatabase = UserDatabase.getInstance();
    private final InventoryDatabase inventoryDatabase = InventoryDatabase.getInstance();

    @FXML
    public void initialize() {
        List<Integer> bannerIds = BannerDatabase.getInstance().getAllBannerIds();
        bannerComboBox.setItems(FXCollections.observableList(bannerIds));
        bannerComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                currentBanner = new Banner(newVal);
                GatchaSystem.GetInstance().setCurrentBanner(currentBanner);
            }
        });

        cookies = userDatabase.getCoinsForUser(LoggedInUser.getUsername());
        updateCoinLabel();
    }

    private void savePulledItemToInventory(GatchaItem item) { //Egyenlőre ez az ami kimenti az adatbázisba az itemeket
        try {
            int userId = userDatabase.getUserIdByUsername(LoggedInUser.getUsername());
            int quantity = 1;
            inventoryDatabase.addItemToInventory(userId, item.getId(), quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onSinglePull(ActionEvent event) {
        if (cookies < 10) {
            showAlert("Nincs elég Coin-od!");
            return;
        }
        if (currentBanner == null) {
            showAlert("Válassz egy Bannert!");
            return;
        }

        cookies -= 10;
        GatchaItem result = GatchaSystem.GetInstance().Pull();
        resultListView.getItems().add(result.GetName());
        savePulledItemToInventory(result);
        updateCoinLabel();
    }

    @FXML
    void onTenPull(ActionEvent event) {
        if (cookies < 100) {
            showAlert("Nincs elég Coinod!");
            return;
        }
        if (currentBanner == null) {
            showAlert("Válassz egy Bannert!");
            return;
        }

        cookies -= 100;
        List<GatchaItem> results = GatchaSystem.GetInstance().TenPull();
        for (GatchaItem item : results) {
            resultListView.getItems().add(item.GetName());
            savePulledItemToInventory(item);
        }
        updateCoinLabel();
    }

    @FXML
    void onBackToMenu(ActionEvent event) {
        String username = LoggedInUser.getUsername();
        if (username != null) {
            userDatabase.updateCoinsForUser(username, cookies);
        }
        navigationService.navigateTo("/com/gatchasim/gatchasim/main_view.fxml", "Főmenü");
        Stage currentStage = (Stage) BackToMenuButton.getScene().getWindow();
        navigationService.closeStage(currentStage);
    }

    private void updateCoinLabel() {
        coinLabel.setText("Coins: " + cookies);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK);
        alert.showAndWait();
    }
}
