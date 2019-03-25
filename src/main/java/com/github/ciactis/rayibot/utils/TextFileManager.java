package com.github.ciactis.rayibot.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TextFileManager {

    public static List<String> getTextFileData(String file) {
        try {
            Path path = Paths.get(ClassLoader.getSystemResource(file).toURI());
            return Files.lines(path).collect(Collectors.toList());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
