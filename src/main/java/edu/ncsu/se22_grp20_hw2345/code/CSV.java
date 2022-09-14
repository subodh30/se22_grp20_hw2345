package edu.ncsu.se22_grp20_hw2345.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSV {

    public static List<Row> csv(String filePath) {
        List<Row> rows = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            bufferedReader.lines().forEach(line -> rows.add(Row.builder()
                    .cells(Arrays.stream(line.split(The.getArgs().get("separator").toString()))
                            .collect(Collectors.toList()))
                    .cooked(Arrays.stream(line.split(The.getArgs().get("separator").toString()))
                            .collect(Collectors.toList()))
                    .isEval(false)
                    .build()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
