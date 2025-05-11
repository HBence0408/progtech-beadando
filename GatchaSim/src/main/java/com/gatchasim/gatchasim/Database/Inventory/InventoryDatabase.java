package com.gatchasim.gatchasim.Database.Inventory;

import com.gatchasim.gatchasim.Database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDatabase extends Database {

    private static InventoryDatabase instance;

    public static InventoryDatabase getInstance() {
        if (instance == null) {
            instance = new InventoryDatabase();
        }
        return instance;
    }

    public int addItemToInventory(int userId, int itemId, int quantity) throws SQLException {
        String sql = "INSERT INTO inventory (user_id, item_id, quantity) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, itemId);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                } else {
                    throw new SQLException("Inventory ID nem generálódott.");
                }
            }
        }
    }

    public void equipItem(int userId, int inventoryId) throws SQLException {
        String checkSql = "SELECT * FROM equiped_item WHERE user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(checkSql)) {

            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String deleteSql = "DELETE FROM equiped_item WHERE user_id = ?";
                try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                    deleteStmt.setInt(1, userId);
                    deleteStmt.executeUpdate();
                }
            }

            String insertSql = "INSERT INTO equiped_item (user_id, equiped_item_id) VALUES (?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setInt(1, userId);
                insertStmt.setInt(2, inventoryId);
                insertStmt.executeUpdate();
            }
        }
    }

    public List<InventoryItem> getUserInventory(String username) throws SQLException {
        List<InventoryItem> items = new ArrayList<>();

        String sql = "SELECT inventory.id, items.name, inventory.quantity " +
                "FROM users " +
                "JOIN inventory ON users.id = inventory.user_id " +
                "JOIN items ON inventory.item_id = items.id " +
                "WHERE users.username = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                InventoryItem item = new InventoryItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity")
                );
                items.add(item);
            }
        }

        return items;
    }

    public int getEquippedItemMultiplier(int userId) throws SQLException {
        String sql = "SELECT items.multiplier FROM equiped_item " +
                "JOIN inventory ON equiped_item.equiped_item_id = inventory.id " +
                "JOIN items ON inventory.item_id = items.id " +
                "WHERE equiped_item.user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("multiplier");
            } else {
                throw new SQLException("No equipped item found for this user!");
            }
        }
    }
    public int getEquippedItemRarity(int userId) throws SQLException {
        String sql = "SELECT items.rarity " +
                "FROM equiped_item " +
                "JOIN inventory ON equiped_item.equiped_item_id = inventory.id " +
                "JOIN items ON inventory.item_id = items.id " +
                "WHERE equiped_item.user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("rarity");
            } else {
                throw new SQLException("No equipped item found for user " + userId);
            }
        }
    }
}
