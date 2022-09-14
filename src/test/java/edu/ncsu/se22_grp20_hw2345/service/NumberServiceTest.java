package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.NumbersData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class NumberServiceTest {

    private NumbersData numsData;

    @Autowired
    private NumberService numsService;

    @BeforeEach
    public void beforeAll(){
        numsService = new NumberService();
        List<String> numsList = Arrays.asList("1", "2", "5", "6", "9", "1", "6", "5", "4", "8");
        numsData = NumbersData.builder().data(numsList).build();
    }
    @Test
    void validMedianTest(){
//        enter code for validating median function


        double observed_median =  numsService.median(numsData.getData());
        Assertions.assertEquals(5, observed_median);

    }

    void validMeanTest(){
//        enter code for validating mean function
        double observed_mean = numsService.mean_calc(numsData.getData());;
        Assertions.assertEquals(5, observed_mean);

    }

    void validStandardDeviation(){
//        enter code for validating the standard deviation function
        double observed_stddeviation = numsService.standardDeviation(numsData.getData());;
        Assertions.assertEquals(5, observed_stddeviation);
    }
}
//