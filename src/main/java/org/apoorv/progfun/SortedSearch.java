package org.apoorv.progfun;

import java.util.Arrays;

public class SortedSearch {
    public static void main(String[] args) {
        int x = 100;
        int[] a = {1, 2, 10, 58, 81, 100, 100, 100, 482};
        System.out.println(Arrays.toString(a));
        System.out.println(linearSearch(a, x));
    }

    public static int linearSearch(int[] a, int x) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                count++;
            } else if (a[i] > x) {
                return count;
            }
        }
        return count;
    }
}
