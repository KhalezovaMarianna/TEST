package com.qaprosoft.carina.demo.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class TheSumOfTheDigitsInNumber {
    static final Logger LOGGER = LogManager.getLogger(TheSumOfTheDigitsInNumber.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        LOGGER.info(sum);
    }
}
