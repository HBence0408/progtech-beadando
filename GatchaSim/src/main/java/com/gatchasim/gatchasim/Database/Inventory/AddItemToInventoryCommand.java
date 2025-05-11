package com.gatchasim.gatchasim.Database.Inventory;

import com.gatchasim.gatchasim.Database.IQueryCommand;

import java.sql.SQLException;

public class AddItemToInventoryCommand implements IQueryCommand<Integer> {
    private final int userId;
    private final int itemId;
    private final int quantity;

    public AddItemToInventoryCommand(int userId, int itemId, int quantity) {
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    @Override
    public Integer execute() throws SQLException {
        return InventoryDatabase.getInstance().addItemToInventory(userId, itemId, quantity);
    }
}

