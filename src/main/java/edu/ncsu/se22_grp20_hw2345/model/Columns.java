package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Columns {
    List<String> names;
    //    Map<String, List<String>> allData;
    List<ASCIICharacters> allData = new ArrayList<>();
    //    List<String> klass;
    //    Map<String, List<String>> X;
//    Map<String, List<String>> Y;
    List<ASCIICharacters> Y = new ArrayList<>();
    List<ASCIICharacters> X = new ArrayList<>();
    ASCIICharacters klass;

    public void read(List<String> names) {
        this.names = names;
        ASCIICharacters col;
        for (int c = 0; c < names.size(); c++) {
            if (Character.isUpperCase(names.get(c).charAt(0))) { //numeric
                col = new Numbers(c, names.get(c));
                allData.add(col);
            } else { //symbols
                col = new Symbols(c, names.get(c));
                allData.add(col);
            }
            String colName = names.get(c);
            int n = colName.length();
            if (colName.charAt(n - 1) != ':') {
                if (colName.charAt(n - 1) == '+' || colName.charAt(n - 1) == '-') {
                    Y.add(new Numbers(c, colName));
                } else {
                    X.add(new Numbers(c, colName));
                }
                if (colName.charAt(n - 1) == '!') {
                    klass = col;
                }
            }
        }
    }

//    public void add(Columns columns) {
//        for (String name : columns.getNames()) {
//            if () {
//
//            }
//        }
//    }
}
