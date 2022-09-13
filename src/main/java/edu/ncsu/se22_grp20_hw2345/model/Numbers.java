package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Numbers {
    private String columnName;
    private Integer columnIndex;
    private int count;
    private ArrayList<Integer> data;
}
