package org.apoorv.progfun;

import org.junit.jupiter.api.Test;

import static org.apoorv.progfun.Determinant.determinant;
import static org.junit.jupiter.api.Assertions.*;

class DeterminantTest {
    @Test
    void t1() {
        double[][] t1 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertEquals(0.0, determinant(t1));
    }

    @Test
    void t2() {
        double[][] t2 = {{5, 2, 1, 4}, {8, 3, 4, 6}, {0, 3, 3, 8}, {12, 1, 15, 4}};
        assertEquals(-144.0, determinant(t2));
    }

    @Test
    void t3() {
        double[][] t3 = {{11, 13, 14, 8}, {3, 6, 13, 1}, {5, 12, 11, 3}, {13, 14, 12, 1}};
        assertEquals(4430.0, determinant(t3));
    }

    @Test
    void t4() {
        double[][] t4 = {{4, 1, 7, 4}, {4, 9, 3, 10}, {2, 2, 6, 2}, {9, 8, 5, 10}};
        assertEquals(-628.0, determinant(t4));
    }

    @Test
    void t5() {
        double[][] t5 = {{6, 5, 1, 2}, {9, 2, 8, 6}, {7, 5, 10, 8}, {4, 6, 2, 10}};
        assertEquals(-1850.0, determinant(t5));
    }

}