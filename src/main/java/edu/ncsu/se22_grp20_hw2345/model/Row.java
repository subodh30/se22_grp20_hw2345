package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class Row {
    List<String> cells;
    boolean isEval;
    List<String> cooked;
}
