package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Row {
    List<String> cells;
    boolean isEval;
    List<String> cooked;
}
