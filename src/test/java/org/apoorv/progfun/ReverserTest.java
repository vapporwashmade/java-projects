package org.apoorv.progfun;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ReverserTest {
    @Test
    public void reverseRandomArray() {
        int r = (int) Math.floor(Math.random()*10)+1;
        int[] a = new int[r];
        for (int i = 0; i < r; i++) {
            a[i] = (int) Math.floor(Math.random()*100);
        }
        int[] b = new int[r];
        System.arraycopy(a, 0, b, 0, r);
//        Reverser.reverse(b);
        Collections.reverse(Arrays.asList(a));
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        assertArrayEquals("Reversed 'a' array must be equal to 'b' array", a, b);
    }
}