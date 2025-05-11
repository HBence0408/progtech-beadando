package com.gatchasim.gatchasim.GatchaSystem;

public class BaseItem implements GatchaItem {

    private int multiplyer;
    private String name;
    private int id;

    @Override
    public int GetMultiplyer() {
        return multiplyer;
    }
    @Override
    public String GetName() { return name; }
    @Override
    public int getId() {
        return id;
    }

    public BaseItem(int id, int multiplyer, String name) {
        this.id = id;
        this.multiplyer = multiplyer;
        this.name = name;
    }

    @Override
    public String toString() {
        return "gatcha item";
    }
}
