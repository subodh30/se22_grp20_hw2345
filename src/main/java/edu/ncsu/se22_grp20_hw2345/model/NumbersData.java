package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Builder
@Getter
@Setter
public class NumbersData {
    private String columnName;
    private Integer columnIndex;
    private int count;
    private ArrayList<Integer> data;
}
