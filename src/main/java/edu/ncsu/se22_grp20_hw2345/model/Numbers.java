package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Data;

import java.util.ArrayList;

//@Data
public class Numbers implements ASCIICharacters {
    private String columnName;
    private Integer columnIndex;
    private int count;
    private ArrayList<Integer> data;

    public Numbers() {

    }

    public Numbers(int c, String s) {
        this.columnIndex = c;
        this.columnName = s;
    }


    @Override
    public Integer mid() {
        return 0;
    }

    @Override
    public Double div() {
        return null;
    }
}
