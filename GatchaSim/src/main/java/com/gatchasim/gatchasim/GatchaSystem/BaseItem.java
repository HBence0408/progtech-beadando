package com.gatchasim.gatchasim.GatchaSystem;

public class BaseItem implements GatchaItem {

    private int multiplyer;
    private String name;

    @Override
    public int GetMultiplyer() {
        return multiplyer;
    }
    @Override
    public String GetName() { return name; }

    public BaseItem(int multiplyer, String name) {
        this.multiplyer = multiplyer;
        this.name = name;
    }

    @Override
    public String toString() {
        return "gatcha item";
    }
}
