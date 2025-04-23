package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabase extends Database {

    private static UserDatabase instance;
    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    public boolean addUser(String username, String password) {
        String sql = "INSERT INTO `user` (username, password) VALUES (?, ?)";

        try (Connection conn = com.gatchasim.gatchasim.GatchaSystem.Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM `user` WHERE username = ? AND password = ?";

        try (Connection conn = com.gatchasim.gatchasim.GatchaSystem.Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
        CommandInvoker invoker = new CommandInvoker();

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