package com.qaprosoft.carina.demo.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Anograms {
    static final Logger LOGGER = LogManager.getLogger(Anograms.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1, s2;
        s1 = scanner.nextLine();
        s2 = scanner.nextLine();
        char[] chArr1 = s1.toCharArray();
        char[] chArr2 = s2.toCharArray();
        for (int i = chArr1.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (chArr1[j] > chArr1[j + 1]) {
                    char tmp = chArr1[j];
                    chArr1[j] = chArr1[j + 1];
                    chArr1[j + 1] = tmp;
                }
            }
        }
        for (int i = chArr2.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (chArr2[j] > chArr2[j + 1]) {
                    char tmp = chArr2[j];
                    chArr2[j] = chArr2[j + 1];
                    chArr2[j + 1] = tmp;
                }
            }
            String valueOfchar1 = String.valueOf(chArr1);
            String valueOfchar2 = String.valueOf(chArr2);
            valueOfchar1 = valueOfchar1.replaceAll(" +", " ");
            valueOfchar2 = valueOfchar2.replaceAll(" +", " ");
            LOGGER.info(valueOfchar1.equals(valueOfchar2));
        }
    }

}
