package com.helmrich.f1analyzer;

import com.helmrich.f1analyzer.domain.interfaces.RaceResultInterface;
import com.helmrich.f1analyzer.io.CSVReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RaceResultLoader implements RaceResultInterface {
    @Override
    public List<List<String>> getRaceResult(int year, int round) {
        CSVReader csvReader = new CSVReader();
        String filePath = String.format("0-plugin/src/main/java/com/helmrich/f1analyzer/io/RaceResults%d-%d.csv", year, round);
        return csvReader.readFile(filePath);
    }
}
