package com.helmrich.f1analyzer.domain.interfaces;

import com.helmrich.f1analyzer.domain.entities.Race;

public interface RaceLoaderInterface {
    Race getRaceResult(int year, int round, String filePath);
}
