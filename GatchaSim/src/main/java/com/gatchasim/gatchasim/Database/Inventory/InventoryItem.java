package com.gatchasim.gatchasim.Database.Inventory;

public class InventoryItem {
    private int inventoryId;
    private String itemName;
    private int quantity;

    public InventoryItem(int inventoryId, String itemName, int quantity) {
        this.inventoryId = inventoryId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return itemName + " x" + quantity;
    }
}

