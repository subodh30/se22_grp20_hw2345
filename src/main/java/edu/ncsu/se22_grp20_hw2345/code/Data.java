package edu.ncsu.se22_grp20_hw2345.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@lombok.Data
public class Data {
    Columns columns;
    List<Row> rows;

    //implement stats, readFile
    public Data(String filePath) {
        List<Row> rows = CSV.csv(filePath);
        for (Row row : rows) {
            add(row);
        }
    }

    public void add(Row row) {
        if (null == this.getColumns()) {
            setColumns(new Columns(row.getCells()));
        } else {
            getColumns().add(row.getCells());
        }
    }


    private double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    public Map<String, String> stats(int decimalPlaces, List<ColumnData> showCols, String functionName) {
        Map<String, String> stats = new HashMap<>();
        for (ColumnData column : showCols) {
            String value;
            if (functionName.equals("mid")) {
                value = column.mid(decimalPlaces).toString();
            } else {
                value = column.div(decimalPlaces).toString();
            }
            stats.put(column.getColumnName(), value);
        }
        return stats;
    }
}
