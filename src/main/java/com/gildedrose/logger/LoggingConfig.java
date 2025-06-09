package com.gildedrose.logger;

import java.util.logging.Handler;
import java.util.logging.Logger;

public class LoggingConfig {
    public static void configure () {
        Logger rootLogger = Logger.getLogger ("");
        for (Handler handler : rootLogger.getHandlers ()) {
            handler.setFormatter (new CustomLogger ());
        }
    }
}
