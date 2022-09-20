package edu.ncsu.se22_grp20_hw2345.code;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class ApplicationTest {

    @Test
    void runs() {
        try {
            Assert.assertTrue(Application.runs("bignum"));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}