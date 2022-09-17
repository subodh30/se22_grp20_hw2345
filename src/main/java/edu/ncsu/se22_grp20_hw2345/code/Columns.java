package edu.ncsu.se22_grp20_hw2345.code;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Columns {
    private List<String> names;
    private List<ColumnData> allData = new ArrayList<>();
    private List<ColumnData> Y;
    private List<ColumnData> X;
    private ColumnData klass;

    public Columns(List<String> columnNames) {
        this.names = columnNames;
        for (int i = 0; i < columnNames.size(); i++) {
            if (Character.isUpperCase(names.get(i).charAt(0))) {
                allData.add(new Numbers(i, names.get(i)));
            } else {
                allData.add(new Symbols(i, names.get(i)));
            }
            if(names.get(i).contains("!") && Character.isUpperCase(names.get(i).charAt(0))){
                klass = new Numbers(i, names.get(i));
            }else {
                klass = new Symbols(i, names.get(i));
            }
        }
    }

    public void add(List<String> values) {
        for (int c = 0; c < names.size(); c++) {
            allData.get(c).add(values.get(c));
        }
    }

    public List<ColumnData> getY() {
        Y = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).contains(":")) {
                continue;
            }
            if (names.get(i).contains("+") || names.get(i).contains("-")) {
                Y.add(allData.get(i));
            }
        }
        return Y;
    }

    public List<ColumnData> getX() {
        X = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).contains(":")) {
                continue;
            }
            if (!names.get(i).contains("+") && !names.get(i).contains("-")) {
                X.add(allData.get(i));
            }
        }
        return X;
    }
}
