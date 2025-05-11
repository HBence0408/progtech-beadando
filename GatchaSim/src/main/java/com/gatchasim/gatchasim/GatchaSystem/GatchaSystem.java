package com.gatchasim.gatchasim.GatchaSystem;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ő egy singleton lesz
public class GatchaSystem {

    Random rnd = new Random();

    private static GatchaSystem instance;
    public static GatchaSystem GetInstance() {
        if (instance == null) {
            instance = new GatchaSystem();
        }
        return instance;
    }

    private Banner currentBanner;

    public void setCurrentBanner(Banner banner) {
        this.currentBanner = banner;
    }

    public Banner getCurrentBanner() {
        return this.currentBanner;
    }

    public GatchaItem Pull(){

        int num = rnd.nextInt(101);
        int fiveStarChance = 1;
        int fourStarChance = 20;

        if (currentBanner.GetPullsSinceLast5Star() > 70){
            fiveStarChance = 1 + (currentBanner.GetPullsSinceLast5Star() - 70) * 5;
        }
        if (currentBanner.GetPullsSinceLast4Star() >= 10){
            fourStarChance = 100;
        }

        if (num <= fiveStarChance){  // még később lehet radiant blessing meg a 50 50 számolása
            return currentBanner.FiveStarPull();
        }else if (num <= fourStarChance){
            return currentBanner.FourStarPull();
        }else {
            return currentBanner.ThreeStarPull();
        }
    }


    public List<GatchaItem> TenPull(){
        List<GatchaItem> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(Pull());
        }
        return results;
    }
    //TODO: 10pull


}
