package com.gatchasim.gatchasim.Database;

public class BannerDatabase extends Database {

     private static BannerDatabase instance;
     public static BannerDatabase getInstance() {
         if (instance == null) {
             instance = new BannerDatabase();
         }
         return instance;
     }


}
