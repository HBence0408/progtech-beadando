package com.gatchasim.gatchasim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login_view.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bejelentkezés");
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.addObserver(new ConsoleLogger());
        logger.addObserver(new FileLogger());
        launch(args);
    }
}