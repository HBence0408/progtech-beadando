package com.gatchasim.gatchasim.JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

    public class MainController {

        @FXML
        private Button CCButton;

        @FXML
        private Button InventoryButton;

        @FXML
        private Button Logout_Button;

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
            // TODO: Kijelentkezés
        }
    }

