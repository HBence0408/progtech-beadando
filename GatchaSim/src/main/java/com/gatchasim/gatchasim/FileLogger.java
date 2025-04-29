package com.gatchasim.gatchasim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements LogObserver {

    private static final String LOG_DIRECTORY = "logs";

    @Override
    public void onError(Exception e) {
        System.out.println("Logging error to console: " + e.getMessage());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_HH_mm");
        String timestamp = dateFormat.format(new Date());
        String fileName = "ErrorLog_" + timestamp + ".txt";

        File logDir = new File(LOG_DIRECTORY);
        if (!logDir.exists()) {
            logDir.mkdir();
        }

        File logFile = new File(logDir, fileName);

        try (PrintWriter writer = new PrintWriter(logFile)) {
            e.printStackTrace(writer);
            System.out.println("Hibafájl hely: " + logFile.getAbsolutePath());
        } catch (FileNotFoundException ex) {
            System.err.println("Hiba a Logolás során: " + ex.getMessage());
        }
    }
}
