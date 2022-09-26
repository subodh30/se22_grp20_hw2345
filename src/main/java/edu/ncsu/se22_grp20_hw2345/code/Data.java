package edu.ncsu.se22_grp20_hw2345.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data Class keeps a list of rows and their sumaries in columns
 */

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

    /**
     *
     *     This function fetches a row and adds its cell values to the columns.
     */

    public void add(Row row) {
        if (null == this.getColumns()) {
            setColumns(new Columns(row.getCells()));
        } else {
            getColumns().add(row.getCells());
        }
    }

    /**
     *
     *     This function takes in a value and the number of decimal places as input and returns the rounded number upto the given decimal places.
     */

    private double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    /**
     *
     * This function is responsible for performing all statistical operations on the given data.
     * It takes in the required parameters and the function name which needs to be operated on the given data.
     * The output of this operation is returned to the calling function.
     */

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
