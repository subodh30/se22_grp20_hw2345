package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.SymbolsData;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class SymbolService {

    private void add(SymbolsData symbolsData, String c) {
        if (c != null && !c.equals("?")) {
            Map<String, Integer> symbolMap = symbolsData.getSymbolMap();
            symbolsData.setCount(symbolsData.getCount() + 1);
            symbolMap.put(c, symbolMap.getOrDefault(c, 0) + 1);
        }
    }

    public void addData(SymbolsData symbolsData) {
        symbolsData.setSymbolMap(new HashMap<>());
        for (String symbol : symbolsData.getData()) {
            add(symbolsData, symbol);
        }
    }

    public String mode(SymbolsData symbolsData) {
        int count = -1;
        String mode = "";
        Map<String, Integer> symbolMap = symbolsData.getSymbolMap();
        for (Map.Entry<String, Integer> entry : symbolMap.entrySet()) {
            if (symbolMap.get(entry.getKey()) > count) {
                count = symbolMap.get(entry.getKey());
                mode = entry.getKey();
            }
        }
        return mode;
    }

    public Double entropy(SymbolsData symbolsData){
        double count = symbolsData.getCount();
        AtomicReference<Double> entropy = new AtomicReference<>(0.0);
        symbolsData.getSymbolMap().values().forEach(y -> {
            double probability =  y / count;
            double logOfProbability = Math.log(probability) / Math.log(2);
            entropy.set(entropy.get() - (probability * logOfProbability));
        });
        return entropy.get();
    }
}
