package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.IQueryCommand;

public class IsUsernameTakenCommand implements IQueryCommand<Boolean> {
    private final String username;

    public IsUsernameTakenCommand(String username) {
        this.username = username;
    }

    @Override
    public Boolean execute() {
        return UserDatabase.getInstance().isUsernameTaken(username);
    }
}
