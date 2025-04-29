package com.gatchasim.gatchasim;

public class ConsoleLogger implements LogObserver {

    @Override
    public void onError(Exception e) {
        System.out.println("[ConsoleLogger] Hiba történt:");
        e.printStackTrace(System.out);
    }
}

