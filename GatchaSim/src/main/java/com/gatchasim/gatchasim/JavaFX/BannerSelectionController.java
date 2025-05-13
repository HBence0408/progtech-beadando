package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Database.Banner.BannerDatabase;
import com.gatchasim.gatchasim.Database.Banner.GetItemsCommand;
import com.gatchasim.gatchasim.Database.Inventory.AddItemToInventoryCommand;
import com.gatchasim.gatchasim.Database.Inventory.InventoryDatabase;
import com.gatchasim.gatchasim.Database.User.GetCoinsForUserCommand;
import com.gatchasim.gatchasim.Database.User.GetUserIdByUsernameCommand;
import com.gatchasim.gatchasim.Database.User.UserDatabase;
import com.gatchasim.gatchasim.GatchaSystem.Banner;
import com.gatchasim.gatchasim.GatchaSystem.GatchaItem;
import com.gatchasim.gatchasim.GatchaSystem.GatchaSystem;
import com.gatchasim.gatchasim.Database.User.LoggedInUser;
import com.gatchasim.gatchasim.GatchaSystem.NotEnoughCoinToPull;
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


    private Banner currentBanner;
    private final NavigationService navigationService = new NavigationService();
    private final UserDatabase userDatabase = UserDatabase.getInstance();
    private final InventoryDatabase inventoryDatabase = InventoryDatabase.getInstance();
    private final GetCoinsForUserCommand getCoins = new GetCoinsForUserCommand();

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

        updateCoinLabel();
    }

    private void savePulledItemToInventory(GatchaItem item) { //Egyenlőre ez az ami kimenti az adatbázisba az itemeket
        try {
            GetUserIdByUsernameCommand getUserId = new GetUserIdByUsernameCommand(LoggedInUser.getUsername());
            // int userId = userDatabase.getUserIdByUsername(LoggedInUser.getUsername());
            int userId = getUserId.execute();
            int quantity = 1;
            // inventoryDatabase.addItemToInventory(userId, item.getId(), quantity);
            AddItemToInventoryCommand addItem = new AddItemToInventoryCommand(userId, item.getId(), quantity);
            addItem.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onSinglePull(ActionEvent event) {
        if (currentBanner == null) {
            showAlert("Válassz egy Bannert!");
            return;
        }

        try {
            GatchaItem result = GatchaSystem.GetInstance().Pull();
            resultListView.getItems().add(result.GetName());
            savePulledItemToInventory(result);
            updateCoinLabel();
        }
        catch (NotEnoughCoinToPull e){
                showAlert("Nincs elég Coinod!");
        }

    }

    @FXML
    void onTenPull(ActionEvent event) {
        if (currentBanner == null) {
            showAlert("Válassz egy Bannert!");
            return;
        }
        try {
            List<GatchaItem> results = GatchaSystem.GetInstance().TenPull();
            for (GatchaItem item : results) {
                resultListView.getItems().add(item.GetName());
                savePulledItemToInventory(item);
                updateCoinLabel();
            }
        }
        catch (NotEnoughCoinToPull e){
            showAlert("Nincs elég Coinod!");
        }

    }

    @FXML
    void onBackToMenu(ActionEvent event) {
        String username = LoggedInUser.getUsername();
        navigationService.navigateTo("/com/gatchasim/gatchasim/main_view.fxml", "Főmenü");
        Stage currentStage = (Stage) BackToMenuButton.getScene().getWindow();
        navigationService.closeStage(currentStage);
    }

    private void updateCoinLabel() {
        coinLabel.setText("Coins: " + getCoins.execute());
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK);
        alert.showAndWait();
    }
}
