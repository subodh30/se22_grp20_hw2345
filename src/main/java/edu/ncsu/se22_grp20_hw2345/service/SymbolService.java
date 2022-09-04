package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.SymbolsData;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SymbolService {

    public void add(SymbolsData symbolsData, Character c) {
        if (c != '?') {
            Map<Character, Integer> symbolMap = symbolsData.getSymbolMap();
            symbolsData.setCount(symbolsData.getCount() + 1);
            symbolMap.put(c, symbolMap.getOrDefault(c, 0) + 1);
        }
    }

    public char mode(SymbolsData symbolsData) {
        int count = -1;
        char mode = 'a';
        Map<Character, Integer> symbolMap = symbolsData.getSymbolMap();
        for (char key : symbolMap.keySet()) {
            if (symbolMap.get(key) > count) {
                count = symbolMap.get(key);
                mode = key;
            }
        }
        return mode;
    }
}
