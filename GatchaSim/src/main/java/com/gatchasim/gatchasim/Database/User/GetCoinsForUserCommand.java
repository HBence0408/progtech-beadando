package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.IQueryCommand;

public class GetCoinsForUserCommand implements IQueryCommand<Integer> {
    private final String username;

    public GetCoinsForUserCommand() {
        this.username = LoggedInUser.getUsername();
    }

    @Override
    public Integer execute() {
        return UserDatabase.getInstance().getCoinsForUser(username);
    }
}
