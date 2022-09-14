package edu.ncsu.se22_grp20_hw2345.code;

import java.util.List;
import java.util.Map;

@lombok.Data
public class Data {
    Columns columns;
    List<Row> rows;

    //implement stats, readFile
    public Data(String filePath) {
        addData(filePath);
    }

    public void addData(String src) {
        List<Row> rows = CSV.csv(src);
        for (Row row : rows) {
            add(row, this);
        }
    }

    public void add(Row row, Data data) {
        if (null == data.getColumns()) {
            data.setColumns(Columns.builder()
                    .names(row.getCells())
                    .build());
        } else {
            data.getRows().add(row);
        }
    }

    private double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    public Map<String, String> stats(int decimalPlaces, ASCIICharacters showCols, String functionName) {
        if (functionName.equals("mid")) {
            Object mid = showCols.mid();

        }
//        return round(showCols.div(), decimalPlaces);
        return null;
    }
}
