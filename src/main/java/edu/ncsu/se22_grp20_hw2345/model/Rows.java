package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class Rows {
    List<List<String>> cells;
    boolean isEval;
    Map<String, String> cooked;
}
