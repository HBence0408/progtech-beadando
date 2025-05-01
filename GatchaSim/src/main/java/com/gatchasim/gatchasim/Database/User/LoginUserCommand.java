package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.IReturningCommand;

import java.sql.SQLException;

public class LoginUserCommand implements IReturningCommand<Boolean> {

    private final String username;
    private final String password;

    public LoginUserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public Boolean execute() throws SQLException {
        return UserDatabase.getInstance().loginUser(username, password);
    }
}
