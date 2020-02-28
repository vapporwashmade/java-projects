package org.apoorv.progfun;

import org.junit.jupiter.api.Test;

import static org.apoorv.progfun.Determinant.determinant;
import static org.junit.jupiter.api.Assertions.*;

class DeterminantTest {

    @Test
    void testCases() {
        double[][] t1 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertEquals(0.0, determinant(t1));
        double[][] t2 = {{5, 2, 1, 4}, {8, 3, 4, 6}, {0, 3, 3, 8}, {12, 1, 15, 4}};
        assertEquals(-144.0, determinant(t2));
        double[][] t3 = {{11, 13, 14, 8}, {3, 6, 13, 1}, {5, 12, 11, 3}, {13, 14, 12, 1}};
        assertEquals(4430.0, determinant(t3));
    }
}