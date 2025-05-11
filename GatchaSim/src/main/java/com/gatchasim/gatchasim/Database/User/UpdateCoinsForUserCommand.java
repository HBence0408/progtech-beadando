package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.IQueryCommand;

public class UpdateCoinsForUserCommand implements IQueryCommand<Void> {
    private final String username;
    private final int coins;

    public UpdateCoinsForUserCommand( int coins) {
        this.username = LoggedInUser.getUsername();
        this.coins = coins;
    }

    @Override
    public Void execute() {
        UserDatabase.getInstance().updateCoinsForUser(username, coins);
        return null;
    }
}
