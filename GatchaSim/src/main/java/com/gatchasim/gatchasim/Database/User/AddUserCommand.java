package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.ICommand;

import java.sql.SQLException;

public class AddUserCommand implements ICommand {

    private final String username;
    private final String password;

    public AddUserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void execute() throws SQLException {
        UserDatabase.getInstance().addUser(username, password);
    }
}
