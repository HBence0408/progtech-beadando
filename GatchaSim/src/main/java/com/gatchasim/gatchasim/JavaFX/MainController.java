package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Database.User.LoggedInUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

        @FXML
        private Button CCButton;

        @FXML
        private Button InventoryButton;

        @FXML
        private Button Logout_Button;

        @FXML
        private Button BannerButton;

        private final NavigationService navigationService = new NavigationService();
        @FXML
        private void ShowCC(ActionEvent event) {
            navigationService.navigateTo("/com/gatchasim/gatchasim/cc_view.fxml", "Cookie Clicker");

            Stage currentStage = (Stage) CCButton.getScene().getWindow();
            navigationService.closeStage(currentStage);
        }

        @FXML
        private void ShowInventory(ActionEvent event) {

            navigationService.navigateTo("/com/gatchasim/gatchasim/inventory_view.fxml", "Inventory");

            Stage currentStage = (Stage) InventoryButton.getScene().getWindow();
            navigationService.closeStage(currentStage);

        }

        @FXML
        private void ShowBanner(ActionEvent event) {
            navigationService.navigateTo("/com/gatchasim/gatchasim/banner_view.fxml", "Bannerek");

            Stage currentStage = (Stage) BannerButton.getScene().getWindow();
            navigationService.closeStage(currentStage);
        }

        @FXML
        private void Logout(ActionEvent event) {
            LoggedInUser.logout();

            navigationService.navigateTo("/com/gatchasim/gatchasim/login_view.fxml", "Bejelentkezés");

            Stage currentStage = (Stage) Logout_Button.getScene().getWindow();
            navigationService.closeStage(currentStage);
        }
    }

