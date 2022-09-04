package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.SymbolsData;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
        for (String key : symbolMap.keySet()) {
            if (symbolMap.get(key) > count) {
                count = symbolMap.get(key);
                mode = key;
            }
        }
        return mode;
    }
}
