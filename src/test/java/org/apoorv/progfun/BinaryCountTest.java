package org.apoorv.progfun;

import org.junit.jupiter.api.Test;

import static org.apoorv.progfun.BinaryCount.binaryCount;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryCountTest {

    @Test
    void binaryCountTest1() {
        int lim = 1_000_000;
        int[] a = new int[lim];
        int x = -1;
        int n = 100;
        for (int i = 0; i < n; i++) {
            a[i] = x;
        }
        assertEquals(100, binaryCount(a, -1));
    }

    @Test
    void binaryCountTest2() {
        int[] a = new int[1_000_000];
        assertEquals(1_000_000, binaryCount(a, 0));
    }

    @Test
    void binaryCountTest3() {
        int[] a = {1, 2, 2, 2, 2, 2, 2, 4};
        assertEquals(6, binaryCount(a, 2));
    }
}