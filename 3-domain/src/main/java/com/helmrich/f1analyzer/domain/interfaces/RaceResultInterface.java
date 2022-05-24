package com.helmrich.f1analyzer.domain.interfaces;

import java.io.IOException;

public interface RaceResultInterface {
    public StringBuffer getRaceResult(int year, int round) throws IOException;
}
