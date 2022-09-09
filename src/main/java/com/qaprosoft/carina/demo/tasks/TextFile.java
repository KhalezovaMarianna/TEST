package com.qaprosoft.carina.demo.tasks;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TextFile {
    static final Logger LOGGER = LogManager.getLogger(TextFile.class);

    public static void main(String[] args) {
            File file = new File("/Users/mkhalezova/IdeaProjects/untitled/src/main/resources/text.txt");
            String text = null;
            try {
                text = StringUtils.lowerCase(FileUtils.readFileToString(file, "UTF-8"))
                        .replaceAll("a([v]{1}[a]{1}){1,}", "---");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
            String[] words = new String[0];
            if (text != null) {
                words = text.split("a([v]{1}[a]{1}){1,}") ;
            }
            TreeMap<String, Integer> map = new TreeMap<>();
            for (String word : words) {
                map.put(word, StringUtils.countMatches(text, word));
            }
            List<String> result = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                result.add(entry.getKey());
            }
               LOGGER.info(result);
        }
    }
