package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.SymbolsData;
import org.springframework.stereotype.Service;

import edu.ncsu.se22_grp20_hw2345.model.NumbersData;

//import edu.ncsu.se22_grp20_hw2345.service.

import edu.ncsu.se22_grp20_hw2345.service.CSVFileService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileReader;


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

//    Function for sorting the array
    private ArrayList<Integer> sortMyArray(ArrayList<Integer> arr){
        for(int i=0; i<arr.size(); i++){
            for(int j=i+1; j< arr.size(); j++){
                int temp = 0;
                if(arr.get(i) > arr.get(j)){
                    temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        return arr;
    }

//    *Function for Median
    public Integer median(ArrayList<Integer> arr){
        ArrayList<Integer> sortedarr = new ArrayList<>(sortMyArray(arr));
        int median = 0;
        if(sortedarr.size()%2 != 0){
//            there are odd number of elements in the sortedarray
            int index = sortedarr.size()/2;
            median = sortedarr.get(index);
        }
        else{
            int index = sortedarr.size()/2;
            median = sortedarr.get(index) + sortedarr.get(index+1);
            median /= 2;
        }
        return median;
    }

}
