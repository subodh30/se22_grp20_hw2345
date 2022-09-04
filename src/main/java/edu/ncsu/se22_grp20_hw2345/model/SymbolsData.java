package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class SymbolsData {
    private int count;
    private String columnName;
    private Integer columnIndex;
    private Map<String, Integer> symbolMap;
    private List<String> data;
}
