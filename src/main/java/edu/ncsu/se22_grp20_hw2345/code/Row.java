package edu.ncsu.se22_grp20_hw2345.code;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * It holds one record, i.e. cell values of a row
 */

@Data
public class Row {
    private List<String> cells;
    private boolean isEval;
    private List<String> cooked;

    public Row(List<String> t) {
        this.cells = t;
        this.isEval = false;
        this.cooked = clone_list(t);
    }

    /**
     *
     * This function initializes 3 variables in the class constructor.
     * Cells is a copy of the input parameter
     * Cooked is a deep copy of the input parameter i.e. a List<String>
     */

    public static List<String> clone_list(List<String> record) {
        List<String> temp_element = new ArrayList<String>();
        for (String element : record) {
            temp_element.add(element);
        }
        return temp_element;
    }
}
