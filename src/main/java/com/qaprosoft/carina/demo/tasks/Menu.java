package com.qaprosoft.carina.demo.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Menu {
    static final Logger LOGGER = LogManager.getLogger(Menu.class);
    private static List<String> results = new ArrayList<>();

    public static void main(String[] args) {

        LOGGER.info("How many coins do you have? ");
        int coins = usersCoins();
        List<Products> menu = new ArrayList<>();
        menu.add(new Products("popcorn", 225));
        menu.add(new Products("coffee", 100));
        menu.add(new Products("cake", 200));
        LOGGER.info("Menu: " + menu);
        LOGGER.info("Your sets:");
        menu.sort(Products::compareTo);
        searchSet(coins, menu);
        LOGGER.info(results);

    }

    public static int usersCoins() {

        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                int coins = Integer.parseInt(in.next());
                if (coins < 0) {
                    LOGGER.info("Incorrect. Try again!");
                } else {
                    return coins;
                }
            } catch (NumberFormatException e) {
                LOGGER.error("Incorrect format. Try again!");
            }
        }
    }

    public static void searchSet(int coins, List<Products> products) {

        String answer = "";
        int sum = coins;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() <= sum) {
                int count = 0;
                String item = "";
                while (sum > 0 && (sum - products.get(i).getPrice() >= 0)) {
                    count++;
                    item = products.get(i).getName() + " - " + count + " pcs.";
                    sum = sum - products.get(i).getPrice();
                }
                answer = answer + item + " ";
            }
        }
        if (!answer.isEmpty()) {
            results.add(answer);
            products.remove(products.remove(0));
            searchSet(coins, products);
        }
    }
}


