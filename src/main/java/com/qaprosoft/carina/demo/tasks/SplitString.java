package com.qaprosoft.carina.demo.tasks;

import java.util.Scanner;

public class SplitString {
    public static void main(String[] args) {
        String str = "abbcddbc";
        char[] strToArray = str.toCharArray(); // Преобразуем строку str в массив символов (char)
        for (int i = 0; i < strToArray.length; i++) {
            char chr = strToArray[i];


            System.out.print(chr);
            if (i + 1 < strToArray.length && strToArray[i + 1] == chr) {
                System.out.print(" \n");

            }

        }

    }
}