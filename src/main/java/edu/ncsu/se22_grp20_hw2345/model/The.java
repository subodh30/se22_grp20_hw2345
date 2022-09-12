package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
public class The {
    private static The  the = null;
    private Map<String, String> args;

    private The(){}
    public static The getThe(){
        if(the == null){
            the = new The();
            the.args = new HashMap<>();
        }
        return the;
    }

    public static void setThe(String[] args){
        System.out.println(Arrays.toString(args));
    }

    public static void updateThe(String key, String value){
        the.args.putIfAbsent(key, value);
    }

}
