package com.gatchasim.gatchasim.Database.Banner;

import com.gatchasim.gatchasim.Database.Database;
import com.gatchasim.gatchasim.GatchaSystem.FiveStarItem;
import com.gatchasim.gatchasim.GatchaSystem.FourStarItem;
import com.gatchasim.gatchasim.GatchaSystem.GatchaItem;
import com.gatchasim.gatchasim.GatchaSystem.ThreeStarItem;

import java.util.List;

public class BannerDatabase extends Database {

     private static BannerDatabase instance;
     public static BannerDatabase getInstance() {
         if (instance == null) {
             instance = new BannerDatabase();
         }
         return instance;
     }

    public List<GatchaItem> getItems(String rarity, String banner){
        // adott táblából a rarity (ritkaság) alapján csillagosak lekérése
        // Ide kell betenni azt hogy amikor az adatbázisból lekérdeztem az Itemet abból csinálok egy BaseItem példányt
        return null;
    }

}
