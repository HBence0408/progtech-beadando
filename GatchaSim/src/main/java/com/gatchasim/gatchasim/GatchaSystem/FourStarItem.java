package com.gatchasim.gatchasim.GatchaSystem;

public class FourStarItem extends GatchaItemDecorator {

    public FourStarItem(GatchaItem gatchaItem) {
        if (gatchaItem instanceof FiveStarItem || gatchaItem instanceof ThreeStarItem) {
            throw new RuntimeException("ez a gatcha item már fivestar vagy threestar,nem lehet fourstar is ez nem megengedett!");
        }
        super(gatchaItem);
    }

    @Override
    public String toString() {
        return "FourStar " + super.toString();
    }
}
