package com.helmrich.f1analyzer.application.test;

import com.helmrich.f1analyzer.RaceResultLoader;
import com.helmrich.f1analyzer.application.DifferenceBetweenDriversCalulatorService;
import com.helmrich.f1analyzer.application.RaceResultService;
import com.helmrich.f1analyzer.domain.entities.RaceResult;
import com.helmrich.f1analyzer.io.CSVReader;
import com.helmrich.f1analyzer.io.ConsoleLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class DifferenceBetweenDriversCalculatorTest {
    private DifferenceBetweenDriversCalulatorService differenceBetweenDriversCalulatorService;
    private RaceResult raceResult;

    @Before
    public void generateResults() {
        differenceBetweenDriversCalulatorService = new DifferenceBetweenDriversCalulatorService(new ConsoleLogger());
        RaceResultService raceResultService = new RaceResultService(new RaceResultLoader(), new CSVReader(), new ConsoleLogger());
        String filePath = new File("").getAbsolutePath();

        raceResult = raceResultService.getRaceResult(2022,1, filePath + "/src/test/java/com/helmrich/f1analyzer/application/test/");
    }

    @Test
    public void testGetSpeedDifference() {
        Assert.assertEquals(5.06,differenceBetweenDriversCalulatorService.getSpeedDifference("LEC", "MSC", raceResult), 0.01);
    }

    @Test
    public void testGetTimeDifference() {
        Assert.assertEquals(32, differenceBetweenDriversCalulatorService.getTimeDifference("LEC", "MSC", raceResult));
    }
}
