package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.CSVData;
import edu.ncsu.se22_grp20_hw2345.model.NumbersData;
import edu.ncsu.se22_grp20_hw2345.model.SymbolsData;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class CSVFileService {
    public CSVData getCSVData(String filePath) {
        Map<Integer, List<String>> csvData = new HashMap<>();
        List<String> data = readFile(filePath);
        String[] headers = data.get(0).split(",");
        storeData(csvData, data, headers);
        List<String> columNames = Arrays.stream(headers).toList();
        Map<String, SymbolsData> symbolData = new HashMap<>();
        Map<String, NumbersData> numbersData = new HashMap<>();

        for (int i = 0; i < headers.length; i++) {
            if (headers[i].charAt(headers[i].length() - 1) != ':') {
                if (Character.isUpperCase(headers[i].charAt(0))) {
                    numbersData.put(headers[i], NumbersData.builder()
                            .columnIndex(i)
                            .columnName(headers[i])
                            .data(csvData.get(i))
                            .build());
                } else {
                    symbolData.put(headers[i], SymbolsData.builder()
                            .columnIndex(i)
                            .columnName(headers[i])
                            .data(csvData.get(i))
                            .build());
                }
            }
        }

        return CSVData.builder()
                .columns(columNames)
                .symbolsData(symbolData)
                .numbersData(numbersData)
                .build();
    }

    private static void storeData(Map<Integer, List<String>> csvData, List<String> data, String[] headers) {
        for (int i = 0; i < headers.length; i++) {
            csvData.put(i, new ArrayList<>());
        }

        data.stream().skip(1).forEach(line -> {
            String[] value = line.split(",");
            for (int i = 0; i < value.length; i++) {
                csvData.get(i).add(value[i]);
            }
        });
    }

    private List<String> readFile(String filePath) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8)) {
            return bufferedReader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
