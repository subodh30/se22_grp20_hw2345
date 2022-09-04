package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.SymbolsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SymbolServiceTest {

    private static SymbolsData symbolsData;

    @Autowired
    SymbolService symbolService;

    @BeforeAll
    private static void beforeAll() {
        List<String> symbolList = Arrays.asList("a", "a", "a", "a", "b", "b", "c");
        symbolsData = SymbolsData.builder()
                .data(symbolList)
                .build();
    }

    @Test
    void validModeTest() {
        symbolService.addData(symbolsData);
        Assertions.assertEquals("a", symbolService.mode(symbolsData));
    }
}