package org.apoorv.recur;

import java.util.Arrays;

// ADD-DOC: recur
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{43, 3, 232, 3, 34, 19, 86, 19};
        int[] array2 = Arrays.copyOf(array, array.length);
        sortIterative(array);
        System.out.println(Arrays.toString(array));
        sortRecursive(array2, 0);
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.equals(array, array2));
    }

    public static void sortIterative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void sortRecursive(int[] arr, int ss) {
        // base case
        if (ss == arr.length - 1) {
            return;
        }
        // recursive case
        int lowIndex = ss;
        for (int i = ss + 1; i < arr.length; i++) {
            if (arr[i] < arr[lowIndex]) {
                lowIndex = i;
            }
        }
        int tmp = arr[ss];
        arr[ss] = arr[lowIndex];
        arr[lowIndex] = tmp;
        sortRecursive(arr, ss + 1);
    }
}
