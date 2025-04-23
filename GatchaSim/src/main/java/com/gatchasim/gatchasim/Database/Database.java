package com.gatchasim.gatchasim.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {
    private final String URL = "jdbc:mysql://localhost:3306/gatchasim";
    private final String USER = "root";
    private final String PASSWORD = "";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

/*
*
*
* egy példa a használatára a command-nak
*
* public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField usernameField = new TextField();
        TextField emailField = new TextField();
        Button addButton = new Button("Add User");

        UserDatabase database = new UserDatabase();
        CommandInvoker invoker = new CommandInvoker(); nekünk még nincs ilyen invoker nem tudom hogy szükséges lenne e
        * lehet közvetlenül is hívni, de azért létre hoztam egy command invokert,

        addButton.setOnAction(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            Command command = new AddUserCommand(database, username, email);
            invoker.execute(command);
        });

        VBox layout = new VBox(10, usernameField, emailField, addButton);
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("User Manager");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*
* */