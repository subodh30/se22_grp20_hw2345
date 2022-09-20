package edu.ncsu.se22_grp20_hw2345.code;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Eg {

    public List<String> methods;
    int fails;

    public Eg() {
        this.fails = 0;
        methods = Arrays.stream(Eg.class.getDeclaredMethods()).map(Method::getName).sorted().collect(Collectors.toList());
    }

    public boolean ALL() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        for (String method : methods) {
            if (!method.equals("ALL")) {
                System.out.println("\n-----------------------------------");
                if (!Application.runs(method)) {
                    fails++;
                }
            }
        }

        System.out.println(fails + " Tests failed.");
        return fails == 0;
    }

    boolean BAD() {
        System.out.println("The field does not exist");
        return true;
    }

    public boolean LS() {
        System.out.println("\nExamples lua csv -e ...");
        for (String method : methods) {
            System.out.println(method);
        }
        return true;
    }

    public boolean the() {
        System.out.println(The.getArgs());
        return true;
    }

    public boolean sym() {
        Symbols symbolsData = new Symbols(0, "TestData");
        for (int q = 0; q < 4; q++) {
            symbolsData.add("a");
        }
        symbolsData.add("b");
        symbolsData.add("b");
        symbolsData.add("c");
        String mode = symbolsData.mid(2);
        Double entropy = symbolsData.div(2);
        System.out.println("Mode = " + mode + "  Entropy = " + entropy);
        try {
            assert mode.equals("a") && entropy == 1.38;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean num() {
        Numbers numbers = new Numbers(0, "TestData");
        for (int i = 1; i <= 100; i++) {
            numbers.add(String.valueOf(i));
        }
        Double mid = numbers.mid(2);
        Double std = numbers.div(2);
        System.out.println("mid = " + mid + " div = " + std);
        try {
            assert mid >= 50 && std > 30.5 && std < 32;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean bignum() {
        Numbers numbers = new Numbers(0, "TestData");
        The.getArgs().put("nums", 32);
        for (int q = 1; q <= 100; q++) {
            numbers.add(String.valueOf(q));
        }
        System.out.printf(numbers.nums().toString());
        return 32 == numbers.getHas().size();
    }

    public boolean csv() {
        int n = 0;
        List<Row> rows = CSV.csv(The.getArgs().get("file").toString());
        for (int i = 0; i < 10; i++) {
            System.out.println(rows.get(i).getCells().toString());
        }
        return true;
    }

    public boolean data() {
        Data data = new Data(The.getArgs().get("file").toString());
        List<ColumnData> columns = data.getColumns().getY();
        for (ColumnData column : columns) {
            Numbers numberColumn = (Numbers) column;
            System.out.println("");
            System.out.print(":at " + numberColumn.getColumnIndex());
            System.out.print(" :hi " + numberColumn.getHigh());
            System.out.print(" :isSorted " + numberColumn.isSorted());
            System.out.print(" :lo " + numberColumn.getLow());
            System.out.print(" :n " + numberColumn.getCount());
            System.out.print(" :name " + numberColumn.getColumnName());
            System.out.print(" :w " + numberColumn.getW());
        }
        return true;
    }

    public boolean stats() {
        Data data = new Data(The.getArgs().get("file").toString());
        Map<String, String> xmidMap = data.stats(2, data.getColumns().getX(), "mid");
        System.out.print("xmid ");
        for (String colName : xmidMap.keySet()) {
            System.out.print(" :" + colName + " " + xmidMap.get(colName));
        }
        System.out.println("");
        Map<String, String> xdivMap = data.stats(3, data.getColumns().getX(), "div");
        System.out.print("xdiv ");
        for (String colName : xdivMap.keySet()) {
            System.out.print(" :" + colName + " " + xdivMap.get(colName));
        }
        Map<String, String> ymidMap = data.stats(2, data.getColumns().getY(), "mid");
        System.out.println("");
        System.out.print("ymid ");
        for (String colName : ymidMap.keySet()) {
            System.out.print(" :" + colName + " " + ymidMap.get(colName));
        }
        Map<String, String> ydivMap = data.stats(3, data.getColumns().getY(), "div");
        System.out.println("");
        System.out.print("ydiv ");
        for (String colName : ydivMap.keySet()) {
            System.out.print(" :" + colName + " " + ydivMap.get(colName));
        }
        return true;
    }

}
