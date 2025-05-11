package com.gatchasim.gatchasim.Database.Inventory;

import com.gatchasim.gatchasim.Database.IQueryCommand;

import java.sql.SQLException;
import java.util.List;

public class GetUserInventoryCommand implements IQueryCommand<List<InventoryItem>> {
    private final String username;

    public GetUserInventoryCommand(String username) {
        this.username = username;
    }

    @Override
    public List<InventoryItem> execute() throws SQLException {
        return InventoryDatabase.getInstance().getUserInventory(username);
    }
}

