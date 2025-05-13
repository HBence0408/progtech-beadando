package com.gatchasim.gatchasim.GatchaSystem;


import com.gatchasim.gatchasim.Database.User.GetCoinsForUserCommand;
import com.gatchasim.gatchasim.Database.User.UpdateCoinsForUserCommand;

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
    private GetCoinsForUserCommand getCoins = new GetCoinsForUserCommand();
    private UpdateCoinsForUserCommand updateCoins;

    private int price = 10;

    public void setCurrentBanner(Banner banner) {
        this.currentBanner = banner;
    }

    public Banner getCurrentBanner() {
        return this.currentBanner;
    }

    public GatchaItem Pull(){

        int coins = getCoins.execute();

        if (coins < price) {
            throw new NotEnoughCoinToPull();
        }

        updateCoins = new UpdateCoinsForUserCommand(coins - price);
        updateCoins.execute();
        int num = rnd.nextInt(101);
        int fiveStarChance = 1;
        int fourStarChance = 20;

        if (currentBanner.GetPullsSinceLast5Star() > 70){
            fiveStarChance = 1 + (currentBanner.GetPullsSinceLast5Star() - 70) * 5;
        }
        if (currentBanner.GetPullsSinceLast4Star() >= 9){
            fourStarChance = 100;
        }

        if (num <= fiveStarChance){
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
}
