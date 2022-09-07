package com.qaprosoft.carina.demo.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrome {
    static final Logger LOGGER = LogManager.getLogger(Palindrome.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        number = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        while (number != 0) {
            nums.add(number % 10);
            number /= 10;
        }
        LOGGER.info(number);
        boolean b = true;
        int size = nums.size();
        for (int i = 0; i < size / 2; i++) {
            if (nums.get(i) != nums.get(size - i - 1)) {
                b = false;
                LOGGER.info("isn't Palindrome");
                break;
            } else {
                LOGGER.info("Palindrome");
            }
        }
    }
}
