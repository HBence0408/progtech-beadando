package com.gatchasim.gatchasim.GatchaSystem;

public abstract class GatchaItemDecorator implements GatchaItem {

    protected GatchaItem gatchaItem;

    public GatchaItemDecorator(GatchaItem gatchaItem) {
        this.gatchaItem = gatchaItem;
    }

    @Override
    public int GetMultiplyer() {
        return gatchaItem.GetMultiplyer();
    }

    @Override
    public String GetName() { return gatchaItem.GetName(); }

    @Override
    public String toString() {
        return gatchaItem.toString();
    }
}
