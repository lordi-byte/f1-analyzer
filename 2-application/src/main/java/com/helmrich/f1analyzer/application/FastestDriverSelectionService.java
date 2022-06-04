package com.helmrich.f1analyzer.application;

import com.helmrich.f1analyzer.domain.entities.RaceResult;
import com.helmrich.f1analyzer.domain.entities.Result;
import com.helmrich.f1analyzer.domain.interfaces.ConsoleLoggingInterface;

import java.util.List;

public class FastestDriverSelectionService {
    private final ConsoleLoggingInterface consoleLogger;

    public FastestDriverSelectionService(ConsoleLoggingInterface consoleLogger) {
        this.consoleLogger = consoleLogger;
    }

    public void getFastestDriver(RaceResult raceResult) {
        List<Result> results = raceResult.getResultList();
        Result fastestResult = null;
        for (int i = 0; i < results.size() -1; i++) {
            Result result1 = results.get(i);
            Result result2 = results.get(i+1);
            if (result1.getFastestLapPosition() < result2.getFastestLapPosition()) {
                fastestResult = result1;
            } else {
                fastestResult = result2;
            }
        }
        consoleLogger.log("Der schnellste Fahrer war: " + fastestResult.getDriver().getGivenName() + " " +
                fastestResult.getDriver().getFamilyName() + " mit einer Zeit von " +
                fastestResult.getFastestLapTime() + " Minuten.");
    }
}
