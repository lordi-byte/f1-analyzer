package com.helmrich.f1analyzer.application;

import com.helmrich.f1analyzer.domain.entities.*;
import com.helmrich.f1analyzer.domain.interfaces.CSVReaderInterface;
import com.helmrich.f1analyzer.domain.interfaces.ConsoleLoggingInterface;
import com.helmrich.f1analyzer.domain.interfaces.RaceResultInterface;

import java.util.ArrayList;
import java.util.List;

public class RaceResultService {
    private final RaceResultInterface raceResultInterface;
    private final CSVReaderInterface csvReader;
    private final ConsoleLoggingInterface consoleLogger;

    public RaceResultService(RaceResultInterface raceResultInterface, CSVReaderInterface csvReader, ConsoleLoggingInterface consoleLogger) {
        this.raceResultInterface = raceResultInterface;
        this.csvReader = csvReader;
        this.consoleLogger = consoleLogger;
    }

    public RaceResult getRaceResult(int year, int round) {
        List<List<String>> raceResult = raceResultInterface.getRaceResult(year, round);
        RaceResult raceResultEntity = mapRaceResultToEntity(year, round, raceResult);
        return raceResultEntity;
    }

    public void logRaceResult(RaceResult raceResult) {
        consoleLogger.log(raceResult.toString());
    }
    
    private RaceResult mapRaceResultToEntity(int year, int round, List<List<String>> raceResult) {
        RaceResult raceResultEntity = new RaceResult();
        Race race = new RaceLoaderService(csvReader).loadRaceInfo(year, round);
        raceResultEntity.setRace(race);
        raceResultEntity.setResultList(new ArrayList<>());
        //TODO: read results. Each row is one result
        for (int i = 1; i < raceResult.size(); i++) {
            List<String> resultItem = raceResult.get(i);
            Result result = new Result();
            Driver driver = new Driver();
            Constructor constructor = new Constructor();

            driver.setDriverId(resultItem.get(0));
            driver.setCode(resultItem.get(6));
            driver.setNumber(Integer.parseInt(resultItem.get(0)));
            driver.setGivenName(resultItem.get(1));
            driver.setFamilyName(resultItem.get(2));
            driver.setBirthDate(resultItem.get(3));
            driver.setNationality(resultItem.get(4));
            result.setDriver(driver);

            constructor.setName(resultItem.get(7));
            constructor.setNationality(resultItem.get(8));
            driver.setConstructor(constructor);

            result.setGrid(Integer.parseInt(resultItem.get(10)));
            result.setLaps(Integer.parseInt(resultItem.get(11)));
            result.setStatus(resultItem.get(12));
            result.setRaceTimeInMilli(Integer.parseInt(resultItem.get(13)));
            result.setFastestLapTime(resultItem.get(15));
            result.setFastestLapAvgSpeed(Double.parseDouble(resultItem.get(16)));
            result.setFastestLapPosition(Integer.parseInt(resultItem.get(17)));
            result.setPosition(resultItem.get(18));
            result.setPoints(Double.parseDouble(resultItem.get(19)));
            raceResultEntity.addResultToList(result);
        }
        return raceResultEntity;
    }
}
