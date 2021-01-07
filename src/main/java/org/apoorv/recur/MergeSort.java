package org.apoorv.recur;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{87, 28, 3, 29, 193, 93, 3, 29, 1932, 29};
        System.out.println(Arrays.toString(sortRecursive(a)));
    }

    public static int[] sortRecursive(int[] a) {
        // base case
        if (a.length <= 1) {
            return a;
        }
        // recursive case
        int mid = a.length/2;
        int[] a1 = sortRecursive(Arrays.copyOfRange(a, 0, mid));
        int[] a2 = sortRecursive(Arrays.copyOfRange(a, mid, a.length));
        int[] merged = new int[a.length];
        return merge(merged, a1, a2);
    }

    public static int[] merge(int[] array, int[] left, int[] right) {
        int li = 0, ri = 0;
        int i = 0;
        for (; li < left.length && ri < right.length; i++) {
            if (left[li] < right[ri]) {
                array[i] = left[li];
                li++;
            } else {
                array[i] = right[ri];
                ri++;
            }
        }
        for (; li < left.length; li++) {
            array[i] = left[li];
            i++;
        }
        for (; ri < right.length; ri++) {
            array[i] = right[ri];
            i++;
        }
        return array;
    }
}
