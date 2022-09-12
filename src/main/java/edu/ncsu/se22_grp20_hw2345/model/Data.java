package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;

import java.util.List;

@lombok.Data
public class Data {
    Columns columns;
    List<Row> rows;
}
