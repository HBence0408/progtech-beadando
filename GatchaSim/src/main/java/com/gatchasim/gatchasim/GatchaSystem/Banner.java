package com.gatchasim.gatchasim.GatchaSystem;

import com.gatchasim.gatchasim.Database.Banner.GetItemsCommand;

import java.util.List;
import java.util.Random;

public class Banner {

    Random rnd = new Random();

    private String BannerName;

    private int pity;
    public int GetPity()
    {
        return pity;
    }

    private int pullsSinceLast4Star;
    public int GetPullsSinceLast4Star(){
        return pullsSinceLast4Star;
    }

    private int pullsSinceLast5Star;
    public int GetPullsSinceLast5Star(){
        return pullsSinceLast5Star;
    }

    private boolean isOn5050;

    public boolean IsOn5050(){
        return isOn5050;
    } // elvesztette e az utóbbbi fifty fiftyt

    protected GetItemsCommand get3starCommand;
    protected GetItemsCommand get4starCommand;
    protected GetItemsCommand get5starCommand;

    public Banner(String name){
        BannerName = name;

        get3starCommand = new GetItemsCommand("3star", BannerName);
        get4starCommand = new GetItemsCommand("4star", BannerName);
        get5starCommand = new GetItemsCommand("5star", BannerName);
    }

    public ThreeStarItem ThreeStarPull(){
        List<GatchaItem> items = get3starCommand.execute();
        GatchaItem item = items.get(rnd.nextInt(items.size()));
        item = new ThreeStarItem(item);
        return (ThreeStarItem) item;
    }

    public FourStarItem FourStarPull(){
        List<GatchaItem> items = get4starCommand.execute();
        GatchaItem item = items.get(rnd.nextInt(items.size()));
        item = new FourStarItem(item);
        return (FourStarItem) item;
    }

    public FiveStarItem FiveStarPull(){
        List<GatchaItem> items = get5starCommand.execute();
        GatchaItem item = items.get(rnd.nextInt(items.size()));
        item = new FiveStarItem(item);
        return (FiveStarItem) item;
        // TODO: 50 50
    }

}