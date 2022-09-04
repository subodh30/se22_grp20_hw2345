package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.SymbolsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SymbolServiceTest {

    private SymbolsData symbolsData;

    @Autowired
    private SymbolService symbolService;

    @BeforeEach
    public void beforeAll() {
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

    @Test
    void validEntropyTest() {
        symbolService.addData(symbolsData);
        Assertions.assertEquals(1.3787834934861756, symbolService.entropy(symbolsData));
    }
}