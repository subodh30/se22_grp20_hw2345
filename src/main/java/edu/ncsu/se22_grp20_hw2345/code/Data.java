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

    public Map<String, String> stats(int decimalPlaces, Map<String, List<String>> showCols, String functionName) {
        Map<String, String> stats = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : showCols.entrySet()) {
            ASCIICharacters column;
            if (Character.isUpperCase(entry.getKey().charAt(0))) {
                column = new Numbers(entry.getValue());
            } else {
                column = new Symbols(entry.getValue());
            }
            String value;
            if (functionName.equals("mid")) {
                value = column.mid(decimalPlaces).toString();
            } else {
                value = column.div(decimalPlaces).toString();
            }
            stats.put(entry.getKey(), value);
        }
        return stats;
    }
}
