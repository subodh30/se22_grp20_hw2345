package edu.ncsu.se22_grp20_hw2345.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@lombok.Data
public class Data {
    Columns columns;
    List<Row> rows;

    public Data(String filePath) {
        addData(filePath);
    }

    public List<Row> getRows(String filePath) {
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

    public void addData(String src) {
        List<Row> rows = getRows(src);
        for (Row row : rows) {
            add(row, this);
        }
    }

    public void add(Row row, Data data) {
        if (null == data.getColumns()) {
            data.setColumns(Columns.builder()
                    .names(row.getCells())
                    .build());
        } else {
            data.getRows().add(row);
        }
    }

    private double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    public Map<String, String> stats(int decimalPlaces, ASCIICharacters showCols, String functionName) {
        if (functionName.equals("mid")) {
            Object mid = showCols.mid();

        }
//        return round(showCols.div(), decimalPlaces);
        return null;
    }
}
