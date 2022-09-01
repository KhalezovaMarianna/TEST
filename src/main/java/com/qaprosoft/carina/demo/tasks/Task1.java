package com.qaprosoft.carina.demo.tasks;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;


public class Task1 {
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
        System.out.println(firstStr);
    }

}

