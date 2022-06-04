package com.helmrich.f1analyzer.application.test;

import com.helmrich.f1analyzer.RaceResultLoader;
import com.helmrich.f1analyzer.application.FastestDriverSelectionService;
import com.helmrich.f1analyzer.application.RaceResultService;
import com.helmrich.f1analyzer.domain.entities.Driver;
import com.helmrich.f1analyzer.domain.entities.RaceResult;
import com.helmrich.f1analyzer.domain.entities.Result;
import com.helmrich.f1analyzer.io.CSVReader;
import com.helmrich.f1analyzer.io.ConsoleLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class FastestDriverSelectionTest {
    private FastestDriverSelectionService fastestDriverSelectionService;
    private RaceResultService raceResultService;
    private RaceResult raceResult;

    @Before
    public void generateResults() {
        raceResultService = new RaceResultService(new RaceResultLoader(), new CSVReader(), new ConsoleLogger());
        String filePath = new File("").getAbsolutePath();

        fastestDriverSelectionService = new FastestDriverSelectionService(new ConsoleLogger());
        raceResult = raceResultService.getRaceResult(2022,1, filePath + "/src/test/java/com/helmrich/f1analyzer/application/test/");
    }

    @Test
    public void testGetFastestDriver() {
        Assert.assertEquals("LEC", fastestDriverSelectionService.getFastestDriver(raceResult).getDriver().getCode());
    }

    @Test
    public void logResult() {
        Result fastestResult = fastestDriverSelectionService.getFastestDriver(raceResult);
        Assert.assertEquals("Der schnellste Fahrer war: Charles Leclerc mit einer Zeit von 1:34.570 Minuten.","Der schnellste Fahrer war: " + fastestResult.getDriver().getGivenName() + " " +
                fastestResult.getDriver().getFamilyName() + " mit einer Zeit von " +
                fastestResult.getFastestLapTime() + " Minuten.");
    }
}
