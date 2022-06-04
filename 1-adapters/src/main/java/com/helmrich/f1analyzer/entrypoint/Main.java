package com.helmrich.f1analyzer.entrypoint;
import com.helmrich.f1analyzer.RaceResultLoader;
import com.helmrich.f1analyzer.application.ConsoleLoggingService;
import com.helmrich.f1analyzer.application.InfoSelectionService;
import com.helmrich.f1analyzer.application.RaceLoaderService;
import com.helmrich.f1analyzer.io.CSVReader;
import com.helmrich.f1analyzer.io.ConsoleLogger;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static ConsoleLoggingService consoleLoggingService;
    private static RaceLoaderService raceLoaderService;
    private static InfoSelectionService infoSelectionService;


    public static void main(String[] args) {
        consoleLoggingService = new ConsoleLoggingService(new ConsoleLogger());
        raceLoaderService = new RaceLoaderService(new CSVReader());
        infoSelectionService = new InfoSelectionService(new RaceResultLoader(), new CSVReader(), new ConsoleLogger());

        consoleLoggingService.log("Willkommen beim F1-Analyzer \n Gib das Rennen an, zu dem du Informationen haben willst.");
        Scanner in = new Scanner(System.in);
        consoleLoggingService.log("Jahr: ");
        int year = in.nextInt();
        consoleLoggingService.log("Rennen: ");
        int round = in.nextInt();

        String filePath = new File("").getAbsolutePath();
        consoleLoggingService.log(raceLoaderService.loadRaceInfo(year, round, filePath + "/0-plugin/src/main/java/com/helmrich/f1analyzer/io/").toString());
        infoSelectionService.startInfoSelection(year, round);
    }
}
