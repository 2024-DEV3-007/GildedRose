package com.gildedrose.logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLogger extends Formatter {

    @Override
    public String format (LogRecord record) {
        return record.getMessage() + System.lineSeparator();
    }
}
