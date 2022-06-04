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

    public Result getFastestDriver(RaceResult raceResult) {
        List<Result> results = raceResult.getResultList();
        Result fastestResult = results.get(0);
        for (int i = 0; i < results.size() -1; i++) {
            Result resultListItem = results.get(i);
            if (fastestResult.getFastestLapPosition() > resultListItem.getFastestLapPosition()) {
                fastestResult = resultListItem;
            }
        }
        return fastestResult;
    }

    public void logResult(Result fastestResult) {
        consoleLogger.log("Der schnellste Fahrer war: " + fastestResult.getDriver().getGivenName() + " " +
                fastestResult.getDriver().getFamilyName() + " mit einer Zeit von " +
                fastestResult.getFastestLapTime() + " Minuten.");
    }
}
