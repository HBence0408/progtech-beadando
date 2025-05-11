package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.IQueryCommand;

public class GetCoinsForUserCommand implements IQueryCommand<Integer> {
    private final String username;

    public GetCoinsForUserCommand(String username) {
        this.username = username;
    }

    @Override
    public Integer execute() {
        return UserDatabase.getInstance().getCoinsForUser(username);
    }
}
