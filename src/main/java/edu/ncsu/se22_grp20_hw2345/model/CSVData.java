package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class CSVData {
    List<String> columns;
    Map<String, Symbols> symbolsData;
    Map<String, NumbersData> numbersData;
}
