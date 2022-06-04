package com.helmrich.f1analyzer.application;

import com.helmrich.f1analyzer.domain.entities.RaceResult;
import com.helmrich.f1analyzer.domain.interfaces.CSVReaderInterface;
import com.helmrich.f1analyzer.domain.interfaces.ConsoleLoggingInterface;
import com.helmrich.f1analyzer.domain.interfaces.RaceResultInterface;

import java.io.File;
import java.util.Scanner;

public class InfoSelectionService {
    private final RaceResultInterface raceResult;
    private final CSVReaderInterface csvReader;
    private final ConsoleLoggingInterface consoleLogger;

    public InfoSelectionService(RaceResultInterface raceResult, CSVReaderInterface csvReader, ConsoleLoggingInterface consoleLogger) {
        this.raceResult = raceResult;
        this.csvReader = csvReader;
        this.consoleLogger = consoleLogger;
    }

    public void startInfoSelection(int year, int round) {
        consoleLogger.log("\nWelche Renninformationen willst du dir ausgeben lassen?\n" +
                "Drücke [1] für die Rennergebnisse des Rennens.\n" +
                "Drücke [2] um den schnellsten Fahrer des Rennens auszugeben.\n" +
                "Drücke [3] um die Zeitdifferenz zwischen zwei Fahrern am Ende des Rennens auszugeben.\n" +
                "Drücke [4] um die Geschwindigkeitsdifferenz zwischen zwei Fahrern am Ende des Rennens auszugeben.\n" +
                "Drücke [0] um das Programm zu beenden.");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        selectInformationOutput(year, round, input);
    }

    public void selectInformationOutput(int year, int round, int userInput) {
        RaceResultService raceResultService = new RaceResultService(raceResult, csvReader, consoleLogger);
        String filePath = new File("").getAbsolutePath();
        RaceResult raceResultEntity = raceResultService.getRaceResult(year, round, filePath + "/0-plugin/src/main/java/com/helmrich/f1analyzer/io/");
        Scanner scanner = new Scanner(System.in);
        String firstDriverCode, secondDriverCode;

        switch (userInput) {
            case 0:
                System.exit(0);
            case 1:
                raceResultService.logRaceResult(raceResultEntity);
                startInfoSelection(year, round);
            case 2:
                FastestDriverSelectionService fastestDriverSelectionService = new FastestDriverSelectionService(consoleLogger);
                fastestDriverSelectionService.logResult(fastestDriverSelectionService.getFastestDriver(raceResultEntity));

                startInfoSelection(year, round);
            case 3:
                consoleLogger.log("Gib die Fahrercodes deiner Fahrer an. Hier ein Beispiel: Charles Leclerc = LEC\n" +
                        " Fahrercode 1: ");
                firstDriverCode = scanner.next();
                consoleLogger.log("Fahrercode 2: ");
                secondDriverCode = scanner.next();
                new DifferenceBetweenDriversCalulatorService(consoleLogger).getTimeDifference(firstDriverCode, secondDriverCode, raceResultEntity);
                startInfoSelection(year, round);
            case 4:
                consoleLogger.log("Gib die Fahrercodes deiner Fahrer an. Hier ein Beispiel: Charles Leclerc = LEC\n" +
                        " Fahrercode 1: ");
                firstDriverCode = scanner.next();
                consoleLogger.log("Fahrercode 2: ");
                secondDriverCode = scanner.next();
                new DifferenceBetweenDriversCalulatorService(consoleLogger).getSpeedDifference(firstDriverCode, secondDriverCode, raceResultEntity);
                startInfoSelection(year, round);
        }
    }
}
