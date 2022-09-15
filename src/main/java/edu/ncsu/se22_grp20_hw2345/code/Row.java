package edu.ncsu.se22_grp20_hw2345.code;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Row {
    List<String> cells;
    boolean isEval;
    List<String> cooked;

    public Row(List<String> t) {
        this.cells = t;
        this.isEval = false;
        this.cooked = clone_list(t);
    }
    public static List<String> clone_list(List<String> record){
        List<String> temp_element = new ArrayList<String>();
        for(String element:record){
            temp_element.add(element);
        }
        return temp_element;
    }
}
