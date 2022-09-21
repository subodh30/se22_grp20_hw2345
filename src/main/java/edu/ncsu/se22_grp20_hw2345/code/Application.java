package edu.ncsu.se22_grp20_hw2345.code;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Application {
    private static final Map<String, Object> old = new HashMap<>();
    static TestEngine eg = new TestEngine();
    private static Application app;

    private Application() {
        if (app == null) {
            app = new Application();
        }
    }

    public static boolean runs(String k) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean out = false;
        String msg = "";
        if (k.equals("nothing")) {
            return true;
        }
        if (!eg.methods.contains(k)) {
            return false;
        }
        Random generator = new Random(Long.parseLong(The.getArgs().get("seed").toString()));
        for (String key : The.getArgs().keySet()) {
            old.put(key, The.getArgs().get(key));
        }
        if (Boolean.parseBoolean(The.getArgs().get("dump").toString())) {
            try {
                eg = new TestEngine();
                Method method = eg.getClass().getDeclaredMethod(k);
                Object result = method.invoke(eg);
                out = (boolean) result;
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Method method = eg.getClass().getDeclaredMethod(k);
                Object result = method.invoke(eg).toString();
                out = Boolean.parseBoolean(result.toString());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw e;
            }
        }
        for (String key : The.getArgs().keySet()) {
            The.getArgs().put(key, old.get(key));
        }
        msg = out ? "PASS" : "FAIL";
        System.out.println("\n!!!!!!\t" + msg + "\t" + k);
        return out;
    }
}

