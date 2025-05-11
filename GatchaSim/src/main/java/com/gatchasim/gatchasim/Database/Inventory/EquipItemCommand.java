package com.gatchasim.gatchasim.Database.Inventory;

import com.gatchasim.gatchasim.Database.ICommand;

import java.sql.SQLException;

public class EquipItemCommand implements ICommand {
    private final int userId;
    private final int inventoryId;

    public EquipItemCommand(int userId, int inventoryId) {
        this.userId = userId;
        this.inventoryId = inventoryId;
    }

    @Override
    public void execute() throws SQLException {
        InventoryDatabase.getInstance().equipItem(userId, inventoryId);
    }
}
