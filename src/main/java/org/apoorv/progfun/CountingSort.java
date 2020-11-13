package org.apoorv.progfun;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {11, 24, 35, 8, 26, 23, 13, 18, 12, 19, 32, 14};
        System.out.println(Arrays.toString(sort(8, 36, arr)));
    }

    public static int[] sort(int start, int end, int[] a) {
        int[] frequency = new int[end - start];
        for (int i = 0; i < a.length; i++) {
            frequency[a[i] - start]++;
        }
        int pos = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                a[pos] = i + start;
                frequency[i]--;
                pos++;
                i--;
            }
        }
        return a;
    }
}
