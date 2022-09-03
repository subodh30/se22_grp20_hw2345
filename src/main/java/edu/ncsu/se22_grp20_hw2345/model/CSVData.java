package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class CSVData {
    List<String> columns;
    Map<String, SymbolsData> symbolsData;
    Map<String, NumbersData> numbersData;
}
