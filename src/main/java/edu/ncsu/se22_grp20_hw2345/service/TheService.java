package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.The;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static edu.ncsu.se22_grp20_hw2345.model.The.getArgs;

@Service
public class TheService {
    public  void setThe(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            for (String arg : getArgs().keySet()) {
                String value = getArgs().get(arg).toString();
                if (key.equals("-" + arg.charAt(0)) || key.equals("--" + arg)) {
                    if(isBoolean(value)) {
                        getArgs().put(arg, !getBoolean(value));
                    } else if (isInteger(value)) {
                        getArgs().put(arg, getInteger(args[i+1]));
                        i++;
                    }else{
                        getArgs().put(arg, args[i+1]);
                        i++;
                    }
                    break;
                }
            }
        }

        if((Boolean) getArgs().get("help")){
            System.out.println(The.helpString);
            System.exit(0);
        }
    }

    private boolean isBoolean(String value) {
        try {
            Boolean.parseBoolean(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean getBoolean(String value) {
        return Boolean.parseBoolean(value);
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private int getInteger(String value){
        return Integer.parseInt(value);
    }

}
