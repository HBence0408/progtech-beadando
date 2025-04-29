package com.gatchasim.gatchasim.JavaFX;

import com.gatchasim.gatchasim.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationService {

    public void navigateTo(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            Logger.getInstance().logError("IOException Történt", e);
            System.exit(0);
        } catch (IllegalStateException e) {
            Logger.getInstance().logError("IllegalStateException (Elírtál valamit az FXML Path-ban ez esetben)", e);
            System.exit(0);
        } catch (Exception e) {
            String exceptionType = e.getClass().getName();
            System.out.println("Valami Nem kóser: " + exceptionType);
            Logger.getInstance().logError(e);
            System.exit(0);
        }
    }

    public void closeStage(Stage stage) {
        if (stage != null) {
            stage.close();
        }
    }
}


