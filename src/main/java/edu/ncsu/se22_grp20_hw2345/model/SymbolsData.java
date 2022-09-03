package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class SymbolsData {
    private String columnName;
    private Integer columnIndex;
    Map<String, Integer> symbolCount;
    List<String> data;
}
