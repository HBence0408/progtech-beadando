package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.IQueryCommand;

import java.sql.SQLException;

public class AddUserAndReturnIdCommand implements IQueryCommand<Integer> {
    private final String username;
    private final String password;

    public AddUserAndReturnIdCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Integer execute() throws SQLException {
        return UserDatabase.getInstance().addUserAndReturnId(username, password);
    }
}
