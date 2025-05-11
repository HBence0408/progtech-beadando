package com.gatchasim.gatchasim.Database.User;

public class LoggedInUser {
    private static String username;

    public static void setUser(String user) {
        username = user;
    }

    public static String getUsername() {
        return username;
    }

    public static void logout() {
        username = null;
    }

    public static boolean isLoggedIn() {
        return username != null;
    }
}
//Ez tárolja hogy ki van bejelentkezve, később lehet átírom hogy ID alapján tároljuk ne felh név alapján,
//Illetve később még ez majd használható az Inventory megjelenítéshez


//TODO ez lehetne singleton