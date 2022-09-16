package edu.ncsu.se22_grp20_hw2345.code;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestEngine {

    private static TestEngine testEngine;
    //    private static Map<String, Object> theMap;
    static Eg eg = new Eg();
    private static Map<String, Object> old = new HashMap<>();

    private TestEngine() {
        if (testEngine == null) {
            testEngine = new TestEngine();
        }
//        this.theMap = The.getArgs();
    }

    public static boolean runs(String k) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean status = false;
        boolean out = false;
        String msg = "";
        if (!eg.sortedList().contains(k)) {
            return false;
        }
//
        Random generator = new Random(Long.parseLong(The.getArgs().get("seed").toString()));
        for (String key : The.getArgs().keySet()) {
            old.put(key, The.getArgs().get(key));
        }
        if (Boolean.parseBoolean(The.getArgs().get("dump").toString())) {
            status = true;
            try {
                eg = new Eg();
                Method method = eg.getClass().getDeclaredMethod(k);

                method.invoke(eg);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Method method = eg.getClass().getDeclaredMethod(k);
                out = Boolean.parseBoolean(method.invoke(eg).toString());
            } catch (NoSuchMethodException e) {
                throw e;
            } catch (InvocationTargetException e) {
                throw e;
            } catch (IllegalAccessException e) {
                throw e;
            }
        }
        for (String key : The.getArgs().keySet()) {
            The.getArgs().put(key, old.get(key));
        }
        msg = status ? out ? "PASS" : "FAIL" : "CRASH";
        System.out.println("!!!!!!" + msg + k + status);
        return out;
    }
}

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

            Class classobj = Eg.class;
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
//
//     -- List test names.
//    function eg.LS()
//    print("\nExamples lua csv -e ...")
//  for _,k in pairs(eg.LIST()) do print(string.format("\t%s",k)) end
//  return true end

    public boolean displayTestNames() {
        System.out.println("\nExamples lua csv -e ...");
        for (String testName : sortedList()) {
            System.out.println(testName);
        }
        return true;
    }

//    -- Run all tests
//    function eg.ALL()
//  for _,k in pairs(eg.LIST()) do
//            if k ~= "ALL" then
//    print"\n-----------------------------------"
//            if not runs(k) then fails=fails+ 1 end end end
//  return true end

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

    //    function eg.the() oo(the); return true end
    public void theTest() {
        System.out.println(The.getArgs());
    }

//    -- The middle and diversity of a set of symbols is called "mode"
//            -- and "entropy" (and the latter is zero when all the symbols
//-- are the same).
//    function eg.sym(  sym,entropy,mode)
//    sym= Sym()
//  for _,x in pairs{"a","a","a","a","b","b","c"} do sym:add(x) end
//    mode, entropy = sym:mid(), sym:div()
//    entropy = (1000*entropy)//1/1000
//    oo({mid=mode, div=entropy})
//            return mode=="a" and 1.37 <= entropy and entropy <=1.38 end

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

//    function eg.num(  num,mid,div)
//    num=Num()
//  for i=1,100 do num:add(i) end
//    mid,div = num:mid(), num:div()
//    print(mid ,div)
//  return 50<= mid and mid<= 52 and 30.5 <div and div<32 end

    public void num() {
        Numbers numbers = new Numbers(0, "TestData");
        for (int i = 1; i <= 100; i++) {
            numbers.add(String.valueOf(i));
        }

    }

//    -- Print some stats on columns.
//    function eg.stats(   data,mid,div)
//    data = Data("../data/auto93.csv")
//    div=function(col) return col:div() end
//    mid=function(col) return col:mid() end
//    print("xmid", o( data:stats(2,data.cols.x, mid)))
//    print("xdiv", o( data:stats(3,data.cols.x, div)))
//    print("ymid", o( data:stats(2,data.cols.y, mid)))
//    print("ydiv", o( data:stats(3,data.cols.y, div)))
//            return true
//    end

    public boolean stats() {
        Data data = new Data("dfgh");
        return true;
    }

}
