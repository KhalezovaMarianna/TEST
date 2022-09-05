package com.qaprosoft.carina.demo.tasks;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;


public class OpeningBrackets {
    static final Logger LOGGER = LogManager.getLogger(OpeningBrackets.class);
    public static void main(String[] args) {
        String firstStr = "3[ab2[df]]";
        while (StringUtils.countMatches(firstStr, "]") > 0) {
            String secondStr = firstStr.substring(firstStr.lastIndexOf('[') + 1);
            String threeStr = secondStr.substring(0, secondStr.length() - StringUtils.countMatches(firstStr, "]"));
            Pattern pattern = Pattern.compile("(\\d+)");
            Matcher matcher = pattern.matcher(firstStr);
            String result = null;
            while (matcher.find()) {
                result = matcher.group(0);
            }
            String finalStr = threeStr.repeat(Integer.parseInt(result));
            String str2 = firstStr.substring(firstStr.lastIndexOf("[") - 1, firstStr.indexOf("]") + 1);
            firstStr = firstStr.replace(str2, finalStr);
        }
        LOGGER.info(firstStr);
    }
//    private final String openBracket = "[";
//    private final String closeBracket = "]";
//
//    public String convertString() {
//        String string = "3[ab2[df4[b]]]";
//
//        StringBuilder stringBuilder = new StringBuilder(string);
//        while (stringBuilder.toString().contains(openBracket)) {
//            int startIndex = stringBuilder.toString().lastIndexOf(openBracket) - 1;
//            int endIndex = stringBuilder.toString().indexOf(closeBracket) + 1;
//            stringBuilder.replace(startIndex, endIndex, openBrackets(stringBuilder.substring(startIndex, endIndex)));
//        }
//        return stringBuilder.toString();
//    }
//
//    private String openBrackets(String expression) {
//        int count = Integer.parseInt(String.valueOf(expression.charAt(0)));
//        String word = StringUtils.substringBetween(expression, openBracket, closeBracket);
//        return String.valueOf(word).repeat(Math.max(0, count));
//    }

}

