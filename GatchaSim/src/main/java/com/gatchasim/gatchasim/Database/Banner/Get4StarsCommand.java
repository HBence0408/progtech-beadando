package com.gatchasim.gatchasim.Database.Banner;


import com.gatchasim.gatchasim.Database.ICommand;
import com.gatchasim.gatchasim.Database.IQueryCommand;
import com.gatchasim.gatchasim.GatchaSystem.FourStarItem;

import java.util.List;

public class Get4StarsCommand implements IQueryCommand<List<FourStarItem>> {

    //privát field, melyik banner
    // még nem tudom mit használunk, lehet enum, vagy az enum példány tárolja a tábla nevét

    public Get4StarsCommand(/*a banner paraméterként hogy melyikből akarjuk lekérni a 4star-okat*/) {
        // itt a paramétereket megadni
        // melyik banner = banner
    }

    @Override
    public List<FourStarItem> execute() {
       return BannerDatabase.getInstance().get4Stars();
    }
}
