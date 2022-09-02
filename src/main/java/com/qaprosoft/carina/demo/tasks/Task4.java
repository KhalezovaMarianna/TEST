package com.qaprosoft.carina.demo.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Task4 {
    static final Logger LOGGER = LogManager.getLogger(Task4.class);

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                LOGGER.info("FizzBuzz");
            } else if (i % 3 == 0) {
                LOGGER.info("Fizz");
            } else if (i % 5 == 0) {
                LOGGER.info("Buzz");
            } else {
                LOGGER.info(i);
            }
            LOGGER.info("," + " ");
        }
    }
}
