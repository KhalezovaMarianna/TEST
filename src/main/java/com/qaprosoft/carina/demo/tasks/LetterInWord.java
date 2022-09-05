package com.qaprosoft.carina.demo.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LetterInWord {
    static final Logger LOGGER = LogManager.getLogger(LetterInWord.class);

    public static void main(String[] args) {
        String string = "ajhdkajhdkjsh";

        Map<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Integer n = letters.get(string.charAt(i));
            if (n == null) {
                letters.put(string.charAt(i), 1);
            } else {
                letters.put(string.charAt(i), ++n);
            }
        }
        LOGGER.info(letters);
    }

}
