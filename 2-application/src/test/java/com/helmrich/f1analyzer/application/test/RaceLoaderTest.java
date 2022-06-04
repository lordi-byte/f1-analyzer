package com.helmrich.f1analyzer.application.test;

import com.helmrich.f1analyzer.application.RaceLoaderService;
import com.helmrich.f1analyzer.domain.entities.Race;
import com.helmrich.f1analyzer.io.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class RaceLoaderTest {
    private RaceLoaderService raceLoaderService;
    private Race race;
    private String filePath;

    @Before
    public void generateRace() {
        raceLoaderService = new RaceLoaderService(new CSVReader());
        filePath = new File("").getAbsolutePath();
        race = new Race();
        race.setRaceName("Bahrain Grand Prix");
        race.setTime("15:00:00Z");
        race.setDate("2022-03-20");
    }

    @Test
    public void testLoadRaceInfo() {
        Race loadedRace = raceLoaderService.loadRaceInfo(2022,1, filePath + "/src/test/java/com/helmrich/f1analyzer/application/test/");
        Assert.assertEquals(race, loadedRace);
    }
}
