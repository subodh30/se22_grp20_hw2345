package edu.ncsu.se22_grp20_hw2345.service;

//import edu.ncsu.se22_grp20_hw2345.model.SymbolsData;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NumberService {

//    private ArrayList<Integer> add(NumbersData numbersData, String c){
//        if (c != null && !c.equals("?")) {
//            ArrayList<Integer> numArray = numbersData.getNumberArray();
//            return numArray;
//        }
//        return null;
//    }
//
//    public void addData(NumbersData numbersData){
//        System.out.println("into adddata");
//        numbersData.setData(new ArrayList<>());
//        for(String num : numbersData.getData()){
//            //todo add function
//            System.out.println(num);
//        }
//    }
//
//    public void nums() throws FileNotFoundException {
////        BufferedReader bf = new BufferedReader(new FileReader("data.csv"));
////        sc.useDelimiter(",");
////        while(sc.hasNext()){
////            System.out.println(sc.next());
////        }
////        sc.close();
//        List<String> numList = Arrays.asList("a", "a", "a", "a", "b", "b", "c");
//        NumbersData numbersData = NumbersData.builder()
//                .data(numList)
//                .build();
////        System.out.println(numbersData);
//        for(String s : numbersData.getData()){
//            System.out.println(s);
//
//        }
////        Scanner sc = new Scanner((Readable) numbersData);
//        addData(numbersData);
////        while(sc.hasNext()){
////            System.out.println(sc.next());
////        }
////        BufferedReader bf = new BufferedReader(new FileReader("data.csv"));
//
////        List<String> numberMap = numbersData.getData();
//////        numberMap.add()
////        CSVFileService csvs = new CSVFileService();
//
////        csvs.readFile();
////        System.out.println();
//    }
//
//    public static void main(String[] args) throws FileNotFoundException {
//        NumberService ns = new NumberService();
//        ns.nums();
//    }


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
//