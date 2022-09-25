package edu.ncsu.se22_grp20_hw2345.code;


import lombok.Data;

/**
 * It is an abstract class inherited by Numbers and Symbols Class
 */
@Data


public abstract class ColumnData {

    public String columnName;
    public int columnIndex;

    public abstract Object mid(int decimalPlaces);

    public abstract Double div(int decimalPlaces);

    public abstract void add(String cellValue);
}
