package com.qaprosoft.carina.demo.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ReverseString {
    static final Logger LOGGER = LogManager.getLogger(ReverseString.class);
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str= scanner.nextLine();
        if (str == null || str.equals("")) {
            LOGGER.info(str);
        }
        int n = str.length();
        char[] newString = new char[n];
        for (int i = 0; i < n; i++) {
            newString[n - i - 1] = str.charAt(i);
        }
        LOGGER.info(String.copyValueOf(newString));
    }
}
