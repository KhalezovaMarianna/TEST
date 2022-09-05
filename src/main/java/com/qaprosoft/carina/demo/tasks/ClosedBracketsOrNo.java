package com.qaprosoft.carina.demo.tasks;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ClosedBracketsOrNo {
    static final Logger LOGGER = LogManager.getLogger(ClosedBracketsOrNo.class);

    public static void main(String[] args) {
        String str = "({)[]}{}";

        Map<String, Integer> openedBracket = new HashMap<>();
        openedBracket.put("(", StringUtils.countMatches(str, "("));
        openedBracket.put("{", StringUtils.countMatches(str, "{"));
        openedBracket.put("[", StringUtils.countMatches(str, "["));

        Map<String, Integer> closedBracket = new HashMap<>();
        closedBracket.put(")", StringUtils.countMatches(str, ")"));
        closedBracket.put("}", StringUtils.countMatches(str, "}"));
        closedBracket.put("]", StringUtils.countMatches(str, "]"));
        if ((openedBracket.get("[") == closedBracket.get("]")) && openedBracket.get("(") == closedBracket.get(")") && openedBracket.get("{") == closedBracket.get("}")) {
            LOGGER.info(true);
        } else {
            LOGGER.info(false);
        }

    }
}

