package edu.ncsu.se22_grp20_hw2345.code;

import java.util.ArrayList;
import java.util.List;

//@Data
public class Numbers implements ASCIICharacters {
    private String columnName;
    private Integer columnIndex;
    private int count;
    private ArrayList<Integer> data;

    public Numbers() {

    }

    public Numbers(int c, String s) {
        this.columnIndex = c;
        this.columnName = s;
    }


    @Override
    public Integer mid() {
        return 0;
    }

    @Override
    public Double div() {
        return null;
    }

    //    Function for converting string array to double
    private List<Double> convertMyArray(List<String> arr) {
        List<Double> newarr = new ArrayList<>();
        for (String i : arr) {
            newarr.add(Double.parseDouble(i));
        }
        return newarr;
    }

    //    Function for sorting the array
    private List<Double> sortMyArray(List<String> arr) {
        List<Double> newarr = new ArrayList<>(convertMyArray(arr));
        for (int i = 0; i < newarr.size(); i++) {
            for (int j = i + 1; j < newarr.size(); j++) {
                double temp = 0;
                if (newarr.get(i) > newarr.get(j)) {
                    temp = newarr.get(i);
                    newarr.set(i, newarr.get(j));
                    newarr.set(j, temp);
                }
            }
        }
        return newarr;
    }

    //    *Function for Median
    public Double median(List<String> arr) {
        List<Double> sortedarr = new ArrayList<>(sortMyArray(arr));
        double median = 0;
        if (sortedarr.size() % 2 != 0) {
//            there are odd number of elements in the sortedarray
            int index = sortedarr.size() / 2;
            median = sortedarr.get(index);
        } else {
            int index = sortedarr.size() / 2;
            median = sortedarr.get(index) + sortedarr.get(index + 1);
            median /= 2;
        }
        return median;
    }

    public double mean_calc(List<String> arr) {
        double mean;
        List<Double> newarr = convertMyArray(arr);
        double sum = 0;
        for (int i = 0; i < newarr.size(); i++) {
            sum += newarr.get(i);
        }
        mean = sum / (newarr.size());
        return mean;
    }

    public Double standardDeviation(List<String> arr) {
        List<Double> newarr = convertMyArray(arr);
        int arr_length = newarr.size();
        double sum = 0.0;
        double std_deviation = 0.0;
        for (int i = 0; i < arr_length; i++) {
            sum += newarr.get(i);
        }
        double mean = mean_calc(arr);
        for (int i = 0; i < arr_length; i++) {
            std_deviation += Math.pow(newarr.get(i) - mean, 2);
        }
        return Math.sqrt(std_deviation / arr_length);
    }
}
