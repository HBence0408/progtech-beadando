package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.IQueryCommand;

import java.sql.SQLException;

public class LoginUserCommand implements IQueryCommand<Boolean> {

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
