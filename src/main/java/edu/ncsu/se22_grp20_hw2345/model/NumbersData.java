package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NumbersData {
    private String columnName;
    private Integer columnIndex;
    List<String> data;
}
