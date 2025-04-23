package com.gatchasim.gatchasim.Database;

public class InventoryDatabase  extends Database {

    private static InventoryDatabase instance;
    public static InventoryDatabase getInstance() {
        if (instance == null) {
            instance = new InventoryDatabase();
        }
        return instance;
    }

}
