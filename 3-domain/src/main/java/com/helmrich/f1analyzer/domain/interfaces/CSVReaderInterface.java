package com.helmrich.f1analyzer.domain.interfaces;

import java.util.List;

public interface CSVReaderInterface {
    List<List<String>> readFile(String filePath);
}
