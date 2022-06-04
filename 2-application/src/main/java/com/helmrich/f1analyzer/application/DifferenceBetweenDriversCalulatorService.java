package com.helmrich.f1analyzer.application;

import com.helmrich.f1analyzer.domain.entities.RaceResult;
import com.helmrich.f1analyzer.domain.entities.Result;
import com.helmrich.f1analyzer.domain.interfaces.ConsoleLoggingInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DifferenceBetweenDriversCalulatorService {
    private final ConsoleLoggingInterface consoleLogger;
    private Result firstResult = null;
    private Result secondResult = null;

    public DifferenceBetweenDriversCalulatorService(ConsoleLoggingInterface consoleLogger) {
        this.consoleLogger = consoleLogger;
    }

    private List<Result> getDriverCodes(String firstDriverCode, String secondDriverCode, RaceResult raceResult) {
        List<Result> results = raceResult.getResultList();
        for (int i = 0; i < results.size(); i++) {
            String driverCode = results.get(i).getDriver().getCode();
            if (Objects.equals(driverCode, firstDriverCode)) {
                firstResult = results.get(i);
            } else if (Objects.equals(driverCode, secondDriverCode)) {
                secondResult = results.get(i);
            }
        }
        List<Result> driverResults = new ArrayList<>();
        driverResults.add(firstResult);
        driverResults.add(secondResult);
        return driverResults;
    }

    public void getTimeDifference(String firstDriverCode, String secondDriverCode, RaceResult raceResult) {
        List<Result> driverResults = getDriverCodes(firstDriverCode, secondDriverCode, raceResult);
        firstResult = driverResults.get(0);
        secondResult = driverResults.get(1);
        if (firstResult == null) consoleLogger.log("Driver Code of first driver is wrong");
        if (secondResult == null) consoleLogger.log("Driver Code of second driver is wrong");
        else {
            int timeDifferenceInMillis = firstResult.getRaceTimeInMilli() - secondResult.getRaceTimeInMilli();
            if (timeDifferenceInMillis < 0) timeDifferenceInMillis *=-1;
            consoleLogger.log("Die Zeitdifferenz der beiden Fahrer liegt bei " +
                    TimeUnit.MILLISECONDS.toSeconds(timeDifferenceInMillis) + " Sekunden");
        }
    }

    public void getSpeedDifference(String firstDriverCode, String secondDriverCode, RaceResult raceResult) {
        List<Result> driverResults = getDriverCodes(firstDriverCode, secondDriverCode, raceResult);
        firstResult = driverResults.get(0);
        secondResult = driverResults.get(1);
        if (firstResult == null) consoleLogger.log("Driver Code of first driver is wrong");
        if (secondResult == null) consoleLogger.log("Driver Code of second driver is wrong");
        else {
            double speedDifference = firstResult.getFastestLapAvgSpeed() - secondResult.getFastestLapAvgSpeed();
            if (speedDifference < 0) speedDifference *=-1;
            speedDifference = Math.floor(speedDifference * 100) / 100;
            consoleLogger.log("Die Geschwindigkeitsdifferenz der beiden Fahrer liegt bei " +
                    speedDifference + "Km/h");
        }
    }
}
