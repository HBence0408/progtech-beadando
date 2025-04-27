package com.gatchasim.gatchasim;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static final Logger instance = new Logger();

    private final List<LogObserver> observers = new ArrayList<>();

    private Logger() {}

    public static Logger getInstance() {
        return instance;
    }

    public void addObserver(LogObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LogObserver observer) {
        observers.remove(observer);
    }

    public void logError(Exception e) {
        for (LogObserver observer : observers) {
            observer.onError(e);
        }
    }
}

