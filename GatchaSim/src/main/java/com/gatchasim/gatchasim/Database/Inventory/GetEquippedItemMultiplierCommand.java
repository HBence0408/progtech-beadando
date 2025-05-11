package com.gatchasim.gatchasim.Database.Inventory;

import com.gatchasim.gatchasim.Database.IQueryCommand;

import java.sql.SQLException;

public class GetEquippedItemMultiplierCommand implements IQueryCommand<Integer> {
    private final int userId;

    public GetEquippedItemMultiplierCommand(int userId) {
        this.userId = userId;
    }

    @Override
    public Integer execute() throws SQLException {
        return InventoryDatabase.getInstance().getEquippedItemMultiplier(userId);
    }
}
