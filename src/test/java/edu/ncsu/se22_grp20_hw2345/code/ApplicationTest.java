package edu.ncsu.se22_grp20_hw2345.code;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class ApplicationTest {

    @Test
    void runs() {
        try {
            String[] args = new String[2];
            args[0] = "-h";
            args[1] = "--dump";
            The.setThe(args);
            Assert.assertTrue(Application.runs("ALL"));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void runsNothing() {
        try {
            Assert.assertTrue(Application.runs("nothing"));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void runsInvalidArgs() {
        try {
            Assert.assertFalse(Application.runs("fake"));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}