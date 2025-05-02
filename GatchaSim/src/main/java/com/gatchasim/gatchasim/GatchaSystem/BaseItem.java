package com.gatchasim.gatchasim.GatchaSystem;

public class BaseItem implements GatchaItem {

    private int multiplyer;

    @Override
    public int GetMultiplyer() {
        return multiplyer;
    }

    @Override
    public String toString() {
        return "gatcha item";
    }
}
