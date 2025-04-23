package com.gatchasim.gatchasim.Database.Banner;

import com.gatchasim.gatchasim.Database.ICommand;
import com.gatchasim.gatchasim.Database.IQueryCommand;
import com.gatchasim.gatchasim.GatchaSystem.FiveStarItem;

import java.util.List;

public class Get5StarsCommand implements IQueryCommand<List<FiveStarItem>> {

    // ugyan az mint 4star esetben kb

    public  Get5StarsCommand() {

    }

    @Override
    public List<FiveStarItem> execute() {
        return BannerDatabase.getInstance().get5Stars();
    }
}
