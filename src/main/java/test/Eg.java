package test;

import edu.ncsu.se22_grp20_hw2345.code.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Eg {

    int fails;

    public Eg() {
        this.fails = 0;
    }

    void bad() {
        System.out.println("The field does not exist");
    }

    public List<String> sortedList() {
        List<String> methodsList = new ArrayList<>();
        try {

            Class<Eg> classobj = Eg.class;
            Method[] methods = classobj.getMethods();

            for (Method method : methods) {
                String methodName = method.getName();
                methodsList.add(methodName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(methodsList);
        return methodsList;
    }

    public boolean displayTestNames() {
        System.out.println("\nExamples lua csv -e ...");
        for (String testName : sortedList()) {
            System.out.println(testName);
        }
        return true;
    }


    public boolean runAllTests() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        for (String method : sortedList()) {
            if (method.equals("ALL")) {
                System.out.println("\n-----------------------------------");
                if (!TestEngine.runs(method)) {
                    fails += 1;
                }
            }
        }
        return true;
    }

    public void theTest() {
        System.out.println(The.getArgs());
    }

    public void sym() {
        Symbols symbolsData = new Symbols(0, "TestData");
        for (int q = 0; q < 4; q++) {
            symbolsData.add("a");
        }
        symbolsData.add("b");
        symbolsData.add("b");
        symbolsData.add("c");
        String mode = symbolsData.mid(2);
        Double entropy = symbolsData.div(2);
        System.out.println("Mode = " + mode + "Entropy = " + entropy);
    }

    public void num() {
        Numbers numbers = new Numbers(0, "TestData");
        for (int i = 1; i <= 100; i++) {
            numbers.add(String.valueOf(i));
        }
        Double mid = numbers.mid(2);
        Double std = numbers.div(2);
        assert mid >= 50 && std > 30.5 && std < 32;
        System.out.printf("mid = " + mid + " div = " + std);
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
