package com.gatchasim.gatchasim.Database.Banner;

import com.gatchasim.gatchasim.Database.Database;
import com.gatchasim.gatchasim.GatchaSystem.FiveStarItem;
import com.gatchasim.gatchasim.GatchaSystem.FourStarItem;
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

    public List<ThreeStarItem> get3Stars(){
        // adott táblából a 3 csillagosak lekérése
        return null;
    }

    public List<FourStarItem> get4Stars(){
         // adott táblából a 4 csillagosak lekérése
        return null;
     }

    public List<FiveStarItem> get5Stars(){
        // adott táblából a 5 csillagosak lekérése
        return null;
    }


}
