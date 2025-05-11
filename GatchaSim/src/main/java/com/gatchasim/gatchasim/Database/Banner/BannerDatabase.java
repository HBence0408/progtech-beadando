package com.gatchasim.gatchasim.Database.Banner;

import com.gatchasim.gatchasim.Database.Database;
import com.gatchasim.gatchasim.GatchaSystem.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BannerDatabase extends Database {

     private static BannerDatabase instance;
     public static BannerDatabase getInstance() {
         if (instance == null) {
             instance = new BannerDatabase();
         }
         return instance;
     }

    public List<GatchaItem> getItems(Integer rarity, Integer banner){
        List<GatchaItem> result = new ArrayList<>();

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT i.id, i.name, i.multiplier " +
                            "FROM banner b " +
                            "JOIN items i ON " +
                            "    (CASE ? " +
                            "        WHEN 3 THEN b.three_star_item " +
                            "        WHEN 4 THEN b.four_star_item " +
                            "        WHEN 5 THEN b.five_star_item " +
                            "     END) = i.id " +
                            "WHERE b.banner_id = ?"
            );

            stmt.setInt(1, rarity);
            stmt.setInt(2, banner);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int multiplier = rs.getInt("multiplier");
                BaseItem baseItem = new BaseItem(id, multiplier, name);
                result.add(baseItem);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public List<Integer> getAllBannerIds() {
        List<Integer> ids = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT banner_id FROM banner");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ids.add(rs.getInt("banner_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
}
