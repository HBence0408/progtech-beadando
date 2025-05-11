package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.IQueryCommand;

import java.sql.SQLException;

public class GetUserIdByUsernameCommand implements IQueryCommand<Integer> {
    private final String username;

    public GetUserIdByUsernameCommand(String username) {
        this.username = username;
    }

    @Override
    public Integer execute() throws SQLException {
        return UserDatabase.getInstance().getUserIdByUsername(username);
    }
}
