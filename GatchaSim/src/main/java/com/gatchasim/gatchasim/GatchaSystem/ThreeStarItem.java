package com.gatchasim.gatchasim.GatchaSystem;

public class ThreeStarItem extends GatchaItemDecorator {

    public ThreeStarItem(GatchaItem gatchaItem) {
        if (gatchaItem instanceof FourStarItem || gatchaItem instanceof ThreeStarItem) {
            throw new RuntimeException("ez a gatcha item már fivestar vagy threestar, nem lehet threestar is ez nem megengedett!");
        }
        super(gatchaItem);
    }

    @Override
    public String toString() {
        return "ThreeStar " + super.toString();
    }
}
