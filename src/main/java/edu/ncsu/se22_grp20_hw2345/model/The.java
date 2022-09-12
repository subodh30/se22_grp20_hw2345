package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
public class The {
    private static The the = null;
    private Map<String, Object> args;

    public static String helpString = "" +
            "CSV : summarized csv file\n" +
            "(c) 2022 Tim Menzies <timm@ieee.org> BSD-2 license\n" +
            "USAGE: lua seen.lua [OPTIONS]\n" +
            "OPTIONS:\n" +
            " -e  --eg        start-up example                      = nothing\n" +
            " -d  --dump      on test failure, exit with stack dump = false\n" +
            " -f  --file      file with csv data                    = ../data/auto93.csv\n" +
            " -h  --help      show help                             = false\n" +
            " -n  --nums      number of nums to keep                = 512\n" +
            " -s  --seed      random number seed                    = 10019\n" +
            " -S  --Seperator feild seperator                       = ,";

    private The() {
    }

    public static Map<String, Object> getArgs() {
        if (the == null) {
            initialize();
        }
        return the.args;
    }

    private static void initialize(){
        the = new The();
        the.args = new HashMap<>();
        the.args.put("eg", "nothing");
        the.args.put("dump", true);
        the.args.put("file", "/data.csv");
        the.args.put("help", false);
        the.args.put("nums", 512);
        the.args.put("seed", 10019);
        the.args.put("Separator", ",");
    }


}
