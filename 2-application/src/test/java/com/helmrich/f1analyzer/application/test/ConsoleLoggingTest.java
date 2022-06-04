package com.helmrich.f1analyzer.application.test;
import com.helmrich.f1analyzer.application.ConsoleLoggingService;
import com.helmrich.f1analyzer.io.ConsoleLogger;
import org.junit.*;
import org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleLoggingTest {
    private ConsoleLoggingService consoleLoggingService;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Before
    public void initConsoleLoggingService() {
        consoleLoggingService = new ConsoleLoggingService(new ConsoleLogger());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testConsoleOuput() {
        consoleLoggingService.log("Test");
        Assert.assertEquals("Test\n", outContent.toString());
    }
}
