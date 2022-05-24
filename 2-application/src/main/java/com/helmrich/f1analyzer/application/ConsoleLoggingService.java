package com.helmrich.f1analyzer.application;

import com.helmrich.f1analyzer.domain.interfaces.ConsoleLoggingInterface;

public class ConsoleLoggingService {
    private final ConsoleLoggingInterface consoleLogger;

    public ConsoleLoggingService(ConsoleLoggingInterface consoleLogger) {
        this.consoleLogger = consoleLogger;
    }

    public void log(String message) {
        consoleLogger.log(message);
    }
}
