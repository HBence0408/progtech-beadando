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
