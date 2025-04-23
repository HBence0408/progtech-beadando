package com.gatchasim.gatchasim.Database.Banner;

import com.gatchasim.gatchasim.Database.IQueryCommand;
import com.gatchasim.gatchasim.GatchaSystem.FiveStarItem;
import com.gatchasim.gatchasim.GatchaSystem.ThreeStarItem;

import java.util.List;

public class Get3StarsCommand implements IQueryCommand<List<ThreeStarItem>> {

    // ugyan az mint 4star esetben kb

    public  Get3StarsCommand() {

    }

    @Override
    public List<ThreeStarItem> execute() {
        return BannerDatabase.getInstance().get3Stars();
    }

}
