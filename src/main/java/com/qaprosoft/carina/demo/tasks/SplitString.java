package com.qaprosoft.carina.demo.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class SplitString {
    static final Logger LOGGER = LogManager.getLogger(SplitString.class);

    public static void main(String[] args) {
        String str = "abbcddbc";
        char[] strToArray = str.toCharArray(); // Преобразуем строку str в массив символов (char)
        for (int i = 0; i < strToArray.length; i++) {
            char chr = strToArray[i];


            System.out.print(chr);
            if (i + 1 < strToArray.length && strToArray[i + 1] == chr) {
                LOGGER.info(" \n");

            }

        }

    }
}