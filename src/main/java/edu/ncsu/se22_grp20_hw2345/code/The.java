package edu.ncsu.se22_grp20_hw2345.code;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class The {
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
    private static The the = null;
    private Map<String, Object> args;

    private The() {
    }

    public static Map<String, Object> getArgs() {
        if (the == null) {
            initialize();
        }
        return the.args;
    }

    private static void initialize() {
        the = new The();
        the.args = new HashMap<>();
        the.args.put("eg", "ALL");
        the.args.put("dump", false);
        the.args.put("file", "src/main/resources/data.csv");
        the.args.put("help", false);
        the.args.put("nums", 512);
        the.args.put("seed", 10019);
        the.args.put("Separator", ",");
    }

    public static void setThe(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            for (String arg : getArgs().keySet()) {
                String value = getArgs().get(arg).toString();
                if (key.equals("-" + arg.charAt(0)) || key.equals("--" + arg)) {
                    if (isBoolean(value)) {
                        getArgs().put(arg, getBoolean(value));
                    } else if (isInteger(value)) {
                        getArgs().put(arg, getInteger(args[i + 1]));
                        i++;
                    } else {
                        getArgs().put(arg, args[i + 1]);
                        i++;
                    }
                    break;
                }
            }
        }

        if ((Boolean) getArgs().get("help")) {
            System.out.println(The.helpString);
            System.exit(0);
        }
    }

    private static boolean isBoolean(String value) {
        if ("True".equalsIgnoreCase(value) || "False".equalsIgnoreCase(value)) {
            return true;
        }
        return false;
    }

    private static boolean getBoolean(String value) {
        return Boolean.parseBoolean(value);
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int getInteger(String value) {
        return Integer.parseInt(value);
    }


}
