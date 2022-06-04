package com.helmrich.f1analyzer.application;

import com.helmrich.f1analyzer.domain.entities.Race;
import com.helmrich.f1analyzer.domain.interfaces.CSVReaderInterface;

import java.util.List;
import java.util.Objects;

public class RaceLoaderService {
    private final CSVReaderInterface csvReader;

    public RaceLoaderService(CSVReaderInterface csvReader) {
        this.csvReader = csvReader;
    }

    public Race loadRaceInfo(int year, int round, String rootPath) {
        Race race = new Race();
        List<List<String>> raceList = csvReader.readFile(rootPath + "RaceList.csv");
        for (List<String> row: raceList) {
            if (Objects.equals(row.get(0), String.valueOf(year)) && Objects.equals(row.get(1), String.valueOf(round))) {
                race.setRaceName(row.get(2));
                race.setDate(row.get(3));
                race.setTime(row.get(4));
            }
        }
        return race;
    }
}
