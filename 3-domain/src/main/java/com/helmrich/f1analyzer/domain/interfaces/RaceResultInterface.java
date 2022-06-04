package com.helmrich.f1analyzer.domain.interfaces;

import java.util.List;

public interface RaceResultInterface {
    List<List<String>> getRaceResult(int year, int round, String rootPath);
}
