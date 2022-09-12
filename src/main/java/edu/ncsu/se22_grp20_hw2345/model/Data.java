package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;

@lombok.Data
@Builder
public class Data {
    Columns columns;
    Rows rows;
}
