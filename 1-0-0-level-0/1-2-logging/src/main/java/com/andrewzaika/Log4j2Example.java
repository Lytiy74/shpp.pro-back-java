package com.andrewzaika;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Example {
    private static final Logger logger = LogManager.getLogger(Log4j2Example.class);
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            logger.info(i);
        }
    }
}
