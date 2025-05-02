package com.gatchasim.gatchasim.Database.Banner;

import com.gatchasim.gatchasim.Database.IQueryCommand;
import com.gatchasim.gatchasim.GatchaSystem.FiveStarItem;
import com.gatchasim.gatchasim.GatchaSystem.GatchaItem;
import com.gatchasim.gatchasim.GatchaSystem.ThreeStarItem;

import java.util.List;

public class GetItemsCommand implements IQueryCommand<List<GatchaItem>> {


    private final String rarity;
    private final String banner;

    public  GetItemsCommand(String rarity, String banner) {
        this.rarity = rarity;
        this.banner = banner;
    }

    @Override
    public List<GatchaItem> execute() {
        return BannerDatabase.getInstance().getItems(rarity, banner);
    }

}
