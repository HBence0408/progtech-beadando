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
            System.out.println("Cookie Clicker page shown.");
            // TODO: Cookie Clicker megoldás
        }

        @FXML
        private void ShowInventory(ActionEvent event) {
            System.out.println("Inventory page shown.");
            // TODO: Inventory megoldás
        }

        @FXML
        private void Logout(ActionEvent event) {
            System.out.println("Logging out...");

            // Navigate to login view
            navigationService.navigateTo("/com/gatchasim/gatchasim/login_view.fxml", "Login");

            // Close current window
            Stage currentStage = (Stage) Logout_Button.getScene().getWindow();
            navigationService.closeStage(currentStage);
        }
    }

