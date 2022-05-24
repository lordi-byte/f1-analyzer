package com.helmrich.f1analyzer.entrypoint;
import com.helmrich.f1analyzer.RaceResultLoader;
import com.helmrich.f1analyzer.application.ConsoleLoggingService;
import com.helmrich.f1analyzer.application.RaceResultService;
import com.helmrich.f1analyzer.io.ConsoleLogger;
import com.helmrich.f1analyzer.io.RaceResultXMLParser;
import org.w3c.dom.Document;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        RaceResultService raceResultService = new RaceResultService(new RaceResultLoader());
        ConsoleLoggingService consoleLoggingService = new ConsoleLoggingService(new ConsoleLogger());

        System.out.println("Willkommen beim F1-Analyzer");
        System.out.println("Gib das Rennen an, zu dem du Informationen haben willst.");
        Scanner in = new Scanner(System.in);
        System.out.print("Jahr: ");
        int year = in.nextInt();
        System.out.print("Rennen: ");
        int round = in.nextInt();
        String response = raceResultService.getRaceResult(year, round).toString();
        consoleLoggingService.log(response);
        //Document doc = new RaceResultXMLParser().convertXMLStringtoDOM(response);
        //System.out.println(doc.getFirstChild().getNextSibling().getNodeName());
    }
}
