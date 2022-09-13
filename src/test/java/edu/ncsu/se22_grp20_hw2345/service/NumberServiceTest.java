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
        List<String> numsList = Arrays.asList("1", "2", "5", "6", "9", "1", "6", "5", "4", "8");
        numsData = NumbersData.builder().data(numsList).build();
    }
    @Test
    void validMedianTest(){
//        enter code for validating median function

    }

    void validMeanTest(){
//        enter code for validating mean function
    }

    void validStandardDeviation(){
//        enter code for validating the standard deviation function
    }
}
