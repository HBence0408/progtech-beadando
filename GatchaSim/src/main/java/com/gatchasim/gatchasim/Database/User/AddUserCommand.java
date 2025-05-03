package com.gatchasim.gatchasim.Database.User;

import com.gatchasim.gatchasim.Database.ICommand;
import com.gatchasim.gatchasim.Database.Inventory.InventoryDatabase;

import java.sql.SQLException;

public class AddUserCommand implements ICommand {

    private final String username;
    private final String password;

    public AddUserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void execute() throws SQLException {
        int userId = UserDatabase.getInstance().addUserAndReturnId(username, password);

        int defaultItemId = 1;
        int inventoryId = InventoryDatabase.getInstance().addItemToInventory(userId, defaultItemId, 1);
        InventoryDatabase.getInstance().equipItem(userId, inventoryId);
    }
}
