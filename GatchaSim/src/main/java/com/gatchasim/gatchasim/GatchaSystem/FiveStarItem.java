package com.gatchasim.gatchasim.GatchaSystem;

public class FiveStarItem extends GatchaItemDecorator{
    public FiveStarItem(GatchaItem gatchaItem) {
        if (gatchaItem instanceof FourStarItem || gatchaItem instanceof ThreeStarItem) {
            throw new RuntimeException("ez a gatcha item már fourstar vagy threestar, nem lehet fivestar is ez nem megengedett!");
        }
        super(gatchaItem);
    }

    @Override
    public String toString() {
        return "FiveStar " + super.toString();
    }
}
