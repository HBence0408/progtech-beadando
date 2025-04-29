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

    public void logError(String message, Exception e) {
        for (LogObserver observer : observers) {
            System.err.println(message);
            observer.onError(e);
        }
    }
}

/*         Hogyan működik a Logger? By Pitykó:
Ha valami olyat csinálsz amiben történhetnek hibák, akkor legyél kedves rakd be egy Try Catch Blokk-ba.

        try {
            Valami ami elcsesződhet
        } catch (Várható Exception e) {
            Logger.getInstance().logError("Üzenet", e); vagy csak szimplán Logger.getInstance().logError();
            System.exit(0); A rendszer kilép, hogy ne történjen további gond hogyha futna a rendszer
                            akkor szükséges ha olyan hibát dob amit nem tud a program lenyelni)
        } catch (Exception e) { //Ez a catch blokk akkor hívódik ha valami olyan hiba keletkezik amire nem számítassz
            String exceptionType = e.getClass().getName();
            System.out.println("Valami Nem kóser: " + exceptionType); //Ez megmondja hogy a nem várt Exception milyen típusú
            Logger.getInstance().logError(e);
            System.exit(0);
        } */

