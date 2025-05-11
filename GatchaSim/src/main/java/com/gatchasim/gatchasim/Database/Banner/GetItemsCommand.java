package com.gatchasim.gatchasim.Database.Banner;

import com.gatchasim.gatchasim.Database.IQueryCommand;
import com.gatchasim.gatchasim.GatchaSystem.FiveStarItem;
import com.gatchasim.gatchasim.GatchaSystem.GatchaItem;
import com.gatchasim.gatchasim.GatchaSystem.ThreeStarItem;

import java.util.List;

public class GetItemsCommand implements IQueryCommand<List<GatchaItem>> {


    private final Integer rarity;
    private final Integer banner;

    public  GetItemsCommand(Integer rarity, Integer banner) {

            this.rarity = rarity;
            this.banner = banner;
        }

        @Override
        public List<GatchaItem> execute() {
            return BannerDatabase.getInstance().getItems(rarity, banner);
        }

    }
