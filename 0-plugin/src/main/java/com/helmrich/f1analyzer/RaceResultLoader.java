package com.helmrich.f1analyzer;

import com.helmrich.f1analyzer.domain.interfaces.RaceResultInterface;
import com.helmrich.f1analyzer.io.CSVReader;

import java.util.List;

public class RaceResultLoader implements RaceResultInterface {
    @Override
    public List<List<String>> getRaceResult(int year, int round, String rootPath) {
        CSVReader csvReader = new CSVReader();
        String filePath = String.format(rootPath + "RaceResults%d-%d.csv", year, round);
        return csvReader.readFile(filePath);
    }
}
