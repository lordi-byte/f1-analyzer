package com.helmrich.f1analyzer.entrypoint;
import com.helmrich.f1analyzer.RaceResultLoader;
import com.helmrich.f1analyzer.application.ConsoleLoggingService;
import com.helmrich.f1analyzer.application.InfoSelectionService;
import com.helmrich.f1analyzer.application.RaceLoaderService;
import com.helmrich.f1analyzer.io.CSVReader;
import com.helmrich.f1analyzer.io.ConsoleLogger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConsoleLoggingService consoleLoggingService = new ConsoleLoggingService(new ConsoleLogger());
        RaceLoaderService raceLoaderService = new RaceLoaderService(new CSVReader());
        InfoSelectionService infoSelectionService = new InfoSelectionService(new RaceResultLoader(), new CSVReader(), new ConsoleLogger());

        consoleLoggingService.log("Willkommen beim F1-Analyzer \n Gib das Rennen an, zu dem du Informationen haben willst.");
        Scanner in = new Scanner(System.in);
        consoleLoggingService.log("Jahr: ");
        int year = in.nextInt();
        consoleLoggingService.log("Rennen: ");
        int round = in.nextInt();

        consoleLoggingService.log(raceLoaderService.loadRaceInfo(year, round).toString());
        infoSelectionService.startInfoSelection(year, round);
    }
}
