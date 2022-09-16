package edu.ncsu.se22_grp20_hw2345.code;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Data
public class Symbols extends ColumnData {
    private int count;

    private Map<String, Integer> symbolMap = new HashMap<>();

    public Symbols(int columnIndex, String columnName) {
        this.setColumnIndex(columnIndex);
        this.setColumnName(columnName);
    }


    @Override
    public void add(String c) {
        if (c != null && !c.equals("?")) {
            Map<String, Integer> symbolMap = this.getSymbolMap();
            this.setCount(this.getCount() + 1);
            symbolMap.put(c, symbolMap.getOrDefault(c, 0) + 1);
        }
    }

    @Override
    public String mid(int decimalPlaces) {
        int count = -1;
        String mode = "";
        Map<String, Integer> symbolMap = this.getSymbolMap();
        for (Map.Entry<String, Integer> entry : symbolMap.entrySet()) {
            if (symbolMap.get(entry.getKey()) > count) {
                count = symbolMap.get(entry.getKey());
                mode = entry.getKey();
            }
        }
        return mode;
    }

    @Override
    public Double div(int decimalPlaces) {
        double count = this.getCount();
        AtomicReference<Double> entropy = new AtomicReference<>(0.0);
        this.getSymbolMap().values().forEach(y -> {
            double probability = y / count;
            double logOfProbability = Math.log(probability) / Math.log(2);
            entropy.set(entropy.get() - (probability * logOfProbability));
        });
        return round(entropy.get(), decimalPlaces);
    }

    private double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }
}
