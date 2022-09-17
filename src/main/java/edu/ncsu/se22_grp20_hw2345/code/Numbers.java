package edu.ncsu.se22_grp20_hw2345.code;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Data
public class Numbers extends ColumnData {

    private int count = 0;
    private Double low = Double.MAX_VALUE;
    private Double high = Double.MIN_VALUE;
    private List<Double> has = new ArrayList<>();
    private boolean isSorted;
    private int w = 1;

    public Numbers(int columnIndex, String columnName) {
        if (columnName.contains("-")) {
            w = -1;
        }
        setColumnName(columnName);
        setColumnIndex(columnIndex);
    }


    @Override
    public Double mid(int decimalPlaces) {
        return 0.0;
    }

    @Override
    public Double div(int decimalPlaces) {
        return median();
    }

    //    function Num:add(v,    pos)
//  if v~="?" then
//    self.n  = self.n + 1
//    self.lo = math.min(v, self.lo)
//    self.hi = math.max(v, self.hi)
//            if     #self._has < the.nums           then pos=1 + (#self._has)
//    elseif math.random() < the.nums/self.n then pos=math.random(#self._has) end
//    if pos then self.isSorted = false
//    self._has[pos] = tonumber(v) end end end
    @Override
    public void add(String cellValue) {
        int bucketSize = (Integer) The.getArgs().get("nums");
        if (!cellValue.equals("?")) {
            Double numValue = Double.parseDouble(cellValue);
            count++;
            low = Math.min(low, numValue);
            high = Math.max(high, numValue);
            if (has.size() < bucketSize) {
                has.add(numValue);
            } else {
                int rnd = new Random().nextInt(has.size());
                has.add(rnd, numValue);
            }
        }
    }

    private double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
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
    public List<Double> nums() {
        if (!isSorted) {
            Collections.sort(has);
            isSorted = true;
        }
        return has;
    }

    //    *Function for Median
    public Double median() {
        List<Double> sortedarr = nums();
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
        return round(median, 3);
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
