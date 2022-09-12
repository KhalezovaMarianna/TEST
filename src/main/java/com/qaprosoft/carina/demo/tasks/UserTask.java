package com.qaprosoft.carina.demo.tasks;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserTask {
    static final Logger LOGGER = LogManager.getLogger(UserTask.class);

    public static void main(String[] args) {
        String str = "+375111111111Ivan_Ivanov5.233+375222222222PetrPetrov6.712";
        List<String> elements = List.of(str.split("\\+"));
        for (int i = 1; i < elements.size(); i++) {
            String phone = elements.get(i).substring(0, 12);
            String string = StringUtils.removeFirst(elements.get(i), phone);
            String initials = string.replaceAll("[^A-Z]", "");
            String nameSurname = string.replaceAll("[^A-Za-z ]", "");
            String name = String.valueOf(initials.charAt(0));
            for (int j = 1; j < nameSurname.length(); j++) {
                if (nameSurname.charAt(j) == initials.charAt(1))
                    break;
                name = name + nameSurname.charAt(j);
            }
            String surname = StringUtils.removeFirst(nameSurname, name);
            String balance = string.replaceAll("[^\\d.]", "");
            List<String> checkBalances = List.of(balance.split("\\."));
            if (checkBalances.get(0).equals("")) {
                LOGGER.info("The balance was entered in the wrong format");
                break;
            } else if (checkBalances.get(1).length() == 2 || checkBalances.get(1).length() == 3) {
                LOGGER.info("\n" + "Phone number: +" + phone + "\n" + "Name: " + name + "\n" + "Surname: " + surname + "\n" + "Balance: " + balance);
            } else {
                LOGGER.info("The balance was entered in the wrong format");
                break;
            }
        }
    }
}
