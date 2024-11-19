package com.andrewzaika;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackExample {
    private static Logger logger = LoggerFactory.getLogger(LogbackExample.class);
    public static void main( String[] args ) throws InterruptedException {
        helloWorldByLogger();
    }

    private static void helloWorldByLogger() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            logger.info("Hello World! ".concat(String.valueOf(i)));
            Thread.sleep(200);
        }

    }
}
