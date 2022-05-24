package com.helmrich.f1analyzer.application;

import com.helmrich.f1analyzer.domain.interfaces.RaceResultInterface;

import java.io.IOException;

public class RaceResultService {
    private final RaceResultInterface raceResultInterface;

    public RaceResultService(RaceResultInterface raceResultInterface) {
        this.raceResultInterface = raceResultInterface;
    }

    public StringBuffer getRaceResult(int year, int round) throws IOException {
        return raceResultInterface.getRaceResult(year, round);
    }
}
