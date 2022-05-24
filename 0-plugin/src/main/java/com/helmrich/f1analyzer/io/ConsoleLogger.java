package com.helmrich.f1analyzer.io;

import com.helmrich.f1analyzer.domain.interfaces.ConsoleLoggingInterface;

public class ConsoleLogger implements ConsoleLoggingInterface {
    public void log(String message) {
        System.out.println(message);
    }
}
