package com.gatchasim.gatchasim.GatchaSystem;

public class NotEnoughCoinToPull extends RuntimeException {
    public NotEnoughCoinToPull() {
        super("not enough coins to pull");
    }
}
