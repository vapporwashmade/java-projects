package org.apoorv.progfun;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryStringTest {
    @Test
    public void basic() {
        String[] act = BinaryString.getStrings(2);
        assertEquals("length should be 4", 4, act.length);
        List<String> actList = Arrays.asList(act);
        assertTrue("has to contain 00", actList.contains("00"));
        assertTrue("has to contain 01", actList.contains("01"));
        assertTrue("has to contain 10", actList.contains("10"));
        assertTrue("has to contain 11", actList.contains("11"));
    }
}