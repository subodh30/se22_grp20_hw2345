//package edu.ncsu.se22_grp20_hw2345.service;
//
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//
//
//@Service
//public class NumberService {
//
//
//    //    Function for sorting the array
//    private ArrayList<Integer> nums(ArrayList<Integer> arr) {
//        return Arrays.sort(arr.toArray());
//    }
//
//
///*
//*
//* Functions add, nums, mid and div
//*
//*
//* */
//    //    *Function for Median
//    public Integer mid(ArrayList<Integer> arr) {
//        ArrayList<Integer> sortedarr = new ArrayList<>(nums(arr));
//        int median = 0;
//        if (sortedarr.size() % 2 != 0) {
////            there are odd number of elements in the sortedarray
//            int index = sortedarr.size() / 2;
//            median = sortedarr.get(index);
//        } else {
//            int index = sortedarr.size() / 2;
//            median = sortedarr.get(index) + sortedarr.get(index + 1);
//            median /= 2;
//        }
//        return median;
//    }
//
//    private float mean_calc(ArrayList<Integer> arr) {
//        float mean;
//        int sum = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            sum += arr.get(i);
//        }
//        mean = sum / (arr.size());
//        return mean
//    }
//
//    public Float div(ArrayList<Integer> arr) {
//        int arr_length = arr.length;
//        float sum = 0.0, std_deviation = 0.0;
//        for (int i = 0; i < arr_length; i++) {
//            sum += arr[i];
//        }
//        float mean = mean_calc(arr);
//        for (int i = 0; i < arr_length; i++) {
//            std_dev += Math.pow(arr[i] - mean, 2);
//        }
//        return Math.sqrt(std_deviation / arr_length);
//    }
//
//
//}
