package com.gatchasim.gatchasim.JavaFX;

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

        private final NavigationService navigationService = new NavigationService();
        @FXML
        private void ShowCC(ActionEvent event) {
            // TODO: Cookie Clicker megoldás
        }

        @FXML
        private void ShowInventory(ActionEvent event) {
            // TODO: Inventory megoldás
        }

        @FXML
        private void ShowBanner(ActionEvent event) {
        // TODO: Bannerek Megjelenítésének megoldása
        }

        @FXML
        private void Logout(ActionEvent event) {
            System.out.println("Kijelentkezés");

            navigationService.navigateTo("/com/gatchasim/gatchasim/login_view.fxml", "Bejelentkezés");

            Stage currentStage = (Stage) Logout_Button.getScene().getWindow();
            navigationService.closeStage(currentStage);
        }
    }

