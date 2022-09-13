package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class NumbersData {
    List<String> data; //items seen
    private String columnName; //column name
    private Integer columnIndex; //column position
    private int count;
    private double low; //lowest seen
    private double high; //highest seen

//    private ArrayList<Integer> numberArray;


    public NumbersData() {
        low = Double.MAX_VALUE;
        high = Double.MIN_VALUE;
    }

    public void checkLowOrHigh(){
        for (String i : data){
            double item = Double.parseDouble(i);
            if(item > high){//item is greater than the observed high value
                high = item;
            }
            if(item < low){//item is less than the observed low value
                low = item;
            }
        }
    }
}
