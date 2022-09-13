package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Builder
@Getter
@Setter
public class Symbols {
    private int count;
    private String columnName;
    private Integer columnIndex;
    private Map<String, Integer> symbolMap;

    private void add(Symbols symbols, String c) {
        if (c != null && !c.equals("?")) {
            Map<String, Integer> symbolMap = symbols.getSymbolMap();
            symbols.setCount(symbols.getCount() + 1);
            symbolMap.put(c, symbolMap.getOrDefault(c, 0) + 1);
        }
    }

    public String mid(Symbols symbols) {
        int count = -1;
        String mode = "";
        Map<String, Integer> symbolMap = symbols.getSymbolMap();
        for (Map.Entry<String, Integer> entry : symbolMap.entrySet()) {
            if (symbolMap.get(entry.getKey()) > count) {
                count = symbolMap.get(entry.getKey());
                mode = entry.getKey();
            }
        }
        return mode;
    }

    public Double div(Symbols symbols){
        double count = symbols.getCount();
        AtomicReference<Double> entropy = new AtomicReference<>(0.0);
        symbols.getSymbolMap().values().forEach(y -> {
            double probability =  y / count;
            double logOfProbability = Math.log(probability) / Math.log(2);
            entropy.set(entropy.get() - (probability * logOfProbability));
        });
        return entropy.get();
    }
}
