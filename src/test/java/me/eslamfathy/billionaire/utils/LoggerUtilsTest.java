package me.eslamfathy.billionaire.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerUtilsTest {

    @Test
    public void logError() {
        LoggerUtils.getInstance().logError("exception", new Exception());
    }

    @Test
    public void logDebug() {
        LoggerUtils.getInstance().logDebug("debug");
    }
}