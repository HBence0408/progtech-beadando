package com.gatchasim.gatchasim.Database.User;


public class UserHelper {


    private final UserDatabase userDatabase;

    public UserHelper(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }
    public static int getLoggedInUserId() {
        String username = LoggedInUser.getUsername();
        if (username == null) {
            throw new IllegalStateException("Nincs éppen bejelentkezett User");
        }

        try {
            return UserDatabase.getInstance().getUserIdByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Hiba a UserID kinyerésében.", e);
        }
    }
}
